library(RMySQL)
library(nnet)
conn <- dbConnect(drv = RMySQL::MySQL(), dbname = "Project_Part_2", host = "tsilerides-patel-database-systems.c7yvomvayohd.us-east-1.rds.amazonaws.com", port = 3306, user = "admin", password = "fanmap-Hidtaq-3parte")
cust_data <- dbGetQuery(conn, "select C.*, P.PRODUCT_NO from Project_Part_2.Customers C, Project_Part_2.Product P where C.PREVIOUS_PLAN = P.PRODUCT_NO")
str(cust_data)
cust_data$PREVIOUS_PLAN_factor <- factor(cust_data$PREVIOUS_PLAN)
cust_data$PREVIOUS_PLAN_output <- relevel(cust_data$PREVIOUS_PLAN_factor, ref = "Basic Coverage Plan")
suggested_product <- multinom(PREVIOUS_PLAN_output~HEIGHT_IN+WEIGHT_LBS+PULSERATE_PER_MIN+BODY_TEMP_DEG_F+BP_SYSTOLIC_MM_HG+BP_DIASTOLIC_MM_HG+CHOLESTEROL_MG_PER_DL+BLOOD_SUGARFASTING_MG_PER_DL+BLOODSUGARAFTERMEALS_MG_PER_DL+DIABETES_MELLITUS+CIRRHOSIS+PNEUMONIA+ALZHEIMERS_DISEASE+HIV_DISEASE+CARDIOVASCULAR_DISEASE+HYPERTENSION, data = cust_data)
summary(suggested_product)
predict(suggested_product, cust_data, type = "prob")
for (i in 1:length(cust_data$CUSTID)) {
  insert_query <- paste("Insert into Project_Part_2.Suggested_Product values ('", cust_data$PRODUCT_NO, "', '", cust_data$CUSTID, "', '", cust_data$PREVIOUS_PLAN_output, "');", sep = "")
  result <-dbGetQuery(conn, insert_query[i])
  }