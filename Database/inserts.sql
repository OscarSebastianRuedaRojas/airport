INSERT INTO document_types (name) VALUES
('Passport'),
('National ID'),
('Driver License');

INSERT INTO customer (id, customer_name, customer_age, document_type_id) VALUES
('123456789', 'John Doe', 34, 1),
('987654321', 'Jane Smith', 28, 2),
('112233445', 'Robert Brown', 45, 3),
('998877665', 'Emily Davis', 30, 1),
('556677889', 'Michael Johnson', 25, 2);

INSERT INTO flight_fare (description, details, value) VALUES
('Economy', 'Basic economy class ticket', 199.99),
('Business', 'Business class ticket with extra legroom', 599.99),
('First Class', 'First class ticket with all amenities', 999.99);

INSERT INTO airlines (airline_name) VALUES
('American Airlines'),
('Delta Airlines'),
('United Airlines');

INSERT INTO tripulation_roles (rol_name) VALUES
('Pilot'),
('Co-Pilot'),
('Flight Attendant');

INSERT INTO countries (id, country_name) VALUES
('USA', 'United States'),
('CAN', 'Canada'),
('MEX', 'Mexico'),
('BRA', 'Brazil'),
('ARG', 'Argentina'),
('GBR', 'United Kingdom'),
('FRA', 'France'),
('GER', 'Germany'),
('JPN', 'Japan'),
('CHN', 'China');

INSERT INTO city (id, city_name, country_id) VALUES
('NYC', 'New York', 'USA'),
('LAX', 'Los Angeles', 'USA'),
('TOR', 'Toronto', 'CAN'),
('VAN', 'Vancouver', 'CAN'),
('MEX', 'Mexico City', 'MEX'),
('GDL', 'Guadalajara', 'MEX'),
('RIO', 'Rio de Janeiro', 'BRA'),
('SAO', 'São Paulo', 'BRA'),
('BUE', 'Buenos Aires', 'ARG'),
('COR', 'Córdoba', 'ARG'),
('LON', 'London', 'GBR'),
('MAN', 'Manchester', 'GBR'),
('PAR', 'Paris', 'FRA'),
('LYO', 'Lyon', 'FRA'),
('BER', 'Berlin', 'GER'),
('MUN', 'Munich', 'GER'),
('TOK', 'Tokyo', 'JPN'),
('OSA', 'Osaka', 'JPN'),
('BJS', 'Beijing', 'CHN'),
('SHA', 'Shanghai', 'CHN');

INSERT INTO trips (trip_date, price_trip, departure_city_id, destination_city_id) VALUES
('2024-07-01', 299.99, 'NYC', 'LAX'),
('2024-07-05', 399.99, 'LAX', 'TOR'),
('2024-07-10', 499.99, 'TOR', 'NYC'),
('2024-07-15', 599.99, 'MEX', 'GDL'),
('2024-07-20', 699.99, 'RIO', 'SAO');

INSERT INTO airport (id, airport_name, city_id) VALUES
('JFK', 'John F. Kennedy International Airport', 'NYC'),
('LAX', 'Los Angeles International Airport', 'LAX'),
('YYZ', 'Toronto Pearson International Airport', 'TOR'),
('MEX', 'Mexico City International Airport', 'MEX'),
('GDL', 'Guadalajara International Airport', 'GDL'),
('GIG', 'Galeão International Airport', 'RIO'),
('GRU', 'São Paulo–Guarulhos International Airport', 'SAO');

INSERT INTO gate (gate_number, airport_id) VALUES
('A1', 'JFK'),
('B2', 'LAX'),
('C3', 'YYZ'),
('D4', 'MEX'),
('E5', 'GDL'),
('F6', 'GIG'),
('G7', 'GRU');

INSERT INTO manufactures (name) VALUES
('Boeing'),
('Airbus'),
('Embraer');

INSERT INTO models (name, manufacture_id) VALUES
('737', 1),
('A320', 2),
('E195', 3);

INSERT INTO statuses (status_name) VALUES
('Operational'),
('Maintenance'),
('Out of Service');

INSERT INTO plane (plates, capacity, fabrication_date, status_id, model_id, airline_id) VALUES
('N123AA', 180, '2010-05-15', 1, 1, 1),
('N456DL', 220, '2015-07-20', 2, 2, 2),
('N789UA', 100, '2020-09-25', 1, 3, 3);

INSERT INTO revisions (revision_date, plane_id) VALUES
('2024-06-01', 1),
('2024-06-10', 2),
('2024-06-15', 3);

INSERT INTO employees (id, employee_name, rol_id, admission_date, airline_id, airport_id) VALUES
('567890123', 'Alice Johnson', 1, '2018-03-12', 1, 'JFK'),
('234567890', 'Bob Wilson', 2, '2017-06-25', 2, 'LAX'),
('345678901', 'Charlie Davis', 3, '2019-11-05', 3, 'YYZ'),
('456789012', 'David Martinez', 1, '2018-08-18', 1, 'MEX'),
('567890234', 'Eva Green', 2, '2016-12-11', 2, 'GDL');

INSERT INTO revemployee (id_employee, id_revision) VALUES
('567890123', 1),
('234567890', 2),
('345678901', 3);

INSERT INTO revisions_details (description, revemployee_id) VALUES
( 'Engine inspection', 1),
( 'Landing gear check', 2),
( 'Cabin pressure test', 3);

INSERT INTO flight_connections (connection_number, trip_id, plane_id, airport_id) VALUES
('FC001', 1, 1, 'JFK'),
('FC002', 2, 2, 'LAX'),
('FC003', 3, 3, 'YYZ'),
('FC004', 4, 1, 'MEX'),
('FC005', 5, 2, 'GDL');

INSERT INTO trip_crews (employees_id, connection_id) VALUES
('567890123', 1),
('234567890', 2),
('345678901', 3),
('456789012', 4),
('567890234', 5);

INSERT INTO trip_booking (date, trip_id) VALUES
('2024-06-20', 1),
('2024-06-21', 2),
('2024-06-22', 3),
('2024-06-23', 4),
('2024-06-24', 5);

INSERT INTO trip_booking_details (trip_booking_id, customer_id, fares_id) VALUES
(1, '123456789', 1),
(2, '987654321', 2),
(3, '112233445', 3),
(4, '998877665', 1),
(5, '556677889', 2);
