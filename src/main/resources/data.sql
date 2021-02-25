insert into customer(cust_id, cust_name, cust_addr) values(1000, 'Mahesh', 'Baner');
insert into customer(cust_id, cust_name, cust_addr) values(1001, 'Aakash', 'Aundh');

insert into product(prod_id,prod_name,prod_mfg_date) values(2000, 'Hard Disk', TO_DATE('15/01/2021','DD/MM/YYYY'));
insert into product(prod_id,prod_name,prod_mfg_date) values(2001, 'Laptop', TO_DATE('20/01/2021','DD/MM/YYYY'));

insert into purchase(purch_id, prod_id, cust_id, purch_date) values(3000, 2000, 1000, TO_DATE('24/01/2021','DD/MM/YYYY'));
insert into purchase(purch_id, prod_id, cust_id, purch_date) values(3001, 2001, 1000, TO_DATE('23/01/2021','DD/MM/YYYY'));
insert into purchase(purch_id, prod_id, cust_id, purch_date) values(3002, 2001, 1000, TO_DATE('24/01/2021','DD/MM/YYYY'));
insert into purchase(purch_id, prod_id, cust_id, purch_date) values(3003, 2001, 1001, TO_DATE('23/01/2021','DD/MM/YYYY'));
insert into purchase(purch_id, prod_id, cust_id, purch_date) values(3004, 2001, 1001, TO_DATE('24/01/2021','DD/MM/YYYY'));
insert into purchase(purch_id, prod_id, cust_id, purch_date) values(3005, 2001, 1001, TO_DATE('24/01/2021','DD/MM/YYYY'));

insert into employee(emp_id, employee_name, level) values(5000, 'Saket', 1);
insert into employee(emp_id, employee_name, manager_name, level) values(5001, 'Unni', 'Saket', 2);
insert into employee(emp_id, employee_name, manager_name, level) values(5002, 'Soumya', 'Unni', 3);
insert into employee(emp_id, employee_name, manager_name, level) values(5003, 'Rajesh', 'Soumya', 4);
insert into employee(emp_id, employee_name, manager_name, level) values(5004, 'Ayush', 'Rajesh', 5);