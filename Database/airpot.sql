create database airport;
use airport;

CREATE TABLE document_types (
    id_document_type INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)   
);

CREATE TABLE customer (
    id VARCHAR(20) PRIMARY KEY,
    customer_name VARCHAR(30),
    customer_age INT,
    document_type_id INT,
    CONSTRAINT fk_document_type_id_costumer FOREIGN KEY (document_type_id) REFERENCES document_types(id_document_type)
);

CREATE TABLE flight_fare (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(20), 
    details TEXT,
    value DECIMAL(7,3)
);

CREATE Table airlines (
    id int auto_increment PRIMARY KEY,
    airline_name VARCHAR(30)
);

CREATE TABLE tripulation_roles (
    id int auto_increment PRIMARY KEY,
    rol_name VARCHAR(40)
);


CREATE TABLE countries(
    id VARCHAR(5) PRIMARY KEY,
    country_name VARCHAR(30)
);

CREATE table city(
    id VARCHAR(5) PRIMARY KEY,
    city_name VARCHAR(30),
    country_id VARCHAR(5),
    CONSTRAINT fk_country_name_id_city Foreign Key (country_id) REFERENCES countries(id) 
);

CREATE Table trips (
    id int auto_increment PRIMARY KEY,
    trip_date DATE,
    price_trip DECIMAL,
    departure_city_id VARCHAR(5),
    destination_city_id VARCHAR(5),
    CONSTRAINT fk_departure_city_id Foreign Key (departure_city_id) REFERENCES city(id), 
    CONSTRAINT fk_destination_city_id Foreign Key (destination_city_id) REFERENCES city(id) 
);

CREATE TABLE airport (
    id VARCHAR(5) PRIMARY KEY,
    airport_name VARCHAR(50),
    city_id VARCHAR(5),
    CONSTRAINT fk_city_id_airport Foreign Key (city_id) REFERENCES city(id)
);

CREATE TABLE gate(
    id int auto_increment PRIMARY KEY,
    gate_number VARCHAR(10),
    airport_id VARCHAR(5),
    CONSTRAINT fk_airport_id_gate Foreign Key (airport_id) REFERENCES airport(id)
);

CREATE TABLE manufactures (
    id int auto_increment PRIMARY KEY,
    name VARCHAR(40)
);

CREATE TABLE models(
    id int auto_increment PRIMARY KEY,
    name VARCHAR(30),
    manufacture_id INT,
    constraint fk_manufacture_id_models Foreign Key (manufacture_id) REFERENCES manufactures(id)
);

CREATE TABLE statuses (
    id int auto_increment PRIMARY KEY,
    status_name VARCHAR(30)
);

CREATE TABLE plane(
    id int auto_increment PRIMARY KEY,
    plates VARCHAR(30),
    capacity int,
    fabrication_date DATE,
    status_id int,
    model_id int,
    airline_id int,
    CONSTRAINT fk_status_id_plane FOREIGN key (status_id) REFERENCES statuses(id),
    CONSTRAINT fk_model_id_plane Foreign Key (model_id) REFERENCES models(id),
    CONSTRAINT fk_airline_id_plane Foreign Key (airline_id) REFERENCES airlines(id)
);
CREATE Table revisions (
    id int auto_increment PRIMARY KEY,
    revision_date DATE,
    plane_id INT,
    CONSTRAINT fk_plane_id_revisions FOREIGN key (plane_id) REFERENCES plane(id)
);



CREATE TABLE employees(
    id VARCHAR(20) PRIMARY KEY,
    employee_name VARCHAR(40),
    rol_id int,
    admission_date date,
    airline_id int,
    airport_id VARCHAR(5),
    CONSTRAINT fk_airline_id_employee Foreign Key (airline_id) REFERENCES airlines(id),
    CONSTRAINT fk_airport_id_employee Foreign Key (airport_id) REFERENCES airport(id),
    CONSTRAINT fk_rol_id FOREIGN Key (rol_id) REFERENCES tripulation_roles(id)
);

CREATE TABLE revemployee (
    id int auto_increment PRIMARY KEY,
    id_employee VARCHAR(20),
    id_revision int,
    CONSTRAINT fk_id_employee Foreign Key (id_employee) REFERENCES employees(id),
    CONSTRAINT fk_id_revision Foreign Key (id_revision) REFERENCES revisions(id)
);

CREATE TABLE revisions_details(
    id INT PRIMARY KEY AUTO_INCREMENT,
    description TEXT,
    revemployee_id int,
    CONSTRAINT fk_revemployee_id FOREIGN KEY (revemployee_id) REFERENCES revemployee(id)
);

CREATE Table flight_connections(
    id int auto_increment  PRIMARY KEY,
    connection_number VARCHAR(20),
    trip_id INT,
    plane_id INT,
    airport_id VARCHAR(5),
    CONSTRAINT fk_trip_id Foreign Key (trip_id) REFERENCES trips(id),
    CONSTRAINT fk_plane_id Foreign Key (plane_id) REFERENCES plane(id),
    CONSTRAINT fk_airport_id Foreign Key (airport_id) REFERENCES airport(id)
);

CREATE Table trip_crews (
    employees_id VARCHAR(20),
    connection_id INT,
    CONSTRAINT fk_employees_id Foreign Key (employees_id) REFERENCES employees(id),
    CONSTRAINT fk_connection_id Foreign Key (connection_id) REFERENCES flight_connections(id)
);

CREATE TABLE trip_booking (
    id INT auto_increment PRIMARY KEY,
    date date,
    trip_id INT,
    seat VARCHAR(5),
    CONSTRAINT fk_trip_id_trip_booking Foreign Key (trip_id) REFERENCES trips(id)
);

CREATE TABLE trip_booking_details (
    id INT PRIMARY KEY auto_increment,
    trip_booking_id INT,
    customer_id VARCHAR(20),
    fares_id int,
    CONSTRAINT fk_trip_booking_id Foreign Key (trip_booking_id) REFERENCES trip_booking(id),
    CONSTRAINT fk_costumer_id Foreign Key (customer_id) REFERENCES customer(id),
    CONSTRAINT fk_fares_id Foreign Key (fares_id) REFERENCES flight_fare(id)
);

CREATE TABLE user_type(
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(30)
);

CREATE TABLE user(
    id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(255),
    id_user_type INT,
    CONSTRAINT fk_user_type FOREIGN KEY (id_user_type) REFERENCES user_type(id)
);


CREATE TABLE payment_methods (
    id INT AUTO_INCREMENT PRIMARY KEY,
    method_name VARCHAR(50) NOT NULL
);

CREATE TABLE customer_payment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id VARCHAR(20),
    payment_method_id INT,
    card_number VARCHAR(20) NOT NULL,
    card_holder_name VARCHAR(50) NOT NULL,
    card_expiry_date DATE NOT NULL,
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer(id),
    CONSTRAINT fk_payment_method_id FOREIGN KEY (payment_method_id) REFERENCES payment_methods(id)
);