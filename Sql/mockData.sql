-- Inserting 15 random records into the Employees table
INSERT INTO Employees ("Id", "FullName", "BirthDate", "Gender", "IdNumber", "PhoneNumber", "Email", "Qualification", "Position", "Salary")
VALUES
    ('NV-0001', 'John Doe', '1990-05-15', 'Male', '1234567890', '1234567890', 'john.doe@example.com', 1, 2, 50000.00),
    ('NV-0002', 'Jane Smith', '1988-09-25', 'Female', '2345678901', '9876543210', 'jane.smith@example.com', 2, 3, 60000.00),
    ('NV-0003', 'Michael Johnson', '1995-02-10', 'Male', '3456789012', '5678901234', 'michael.johnson@example.com', 1, 1, 45000.00),
    ('NV-0004', 'Emily Brown', '1992-11-18', 'Female', '4567890123', '3456789012', 'emily.brown@example.com', 3, 2, 55000.00),
    ('NV-0005', 'David Wilson', '1987-07-07', 'Male', '5678901234', '7890123456', 'david.wilson@example.com', 2, 3, 62000.00),
    ('NV-0006', 'Sarah Garcia', '1993-04-30', 'Female', '6789012345', '2345678901', 'sarah.garcia@example.com', 1, 2, 51000.00),
    ('NV-0007', 'James Martinez', '1991-12-22', 'Male', '7890123456', '9012345678', 'james.martinez@example.com', 3, 1, 47000.00),
    ('NV-0008', 'Linda Rodriguez', '1989-08-14', 'Female', '8901234567', '4567890123', 'linda.rodriguez@example.com', 2, 3, 59000.00),
    ('NV-0009', 'Christopher Lee', '1994-06-02', 'Male', '9012345678', '6789012345', 'christopher.lee@example.com', 3, 2, 53000.00),
    ('NV-0010', 'Amanda Harris', '1990-03-05', 'Female', '0123456789', '0123456789', 'amanda.harris@example.com', 1, 1, 48000.00),
    ('NV-0011', 'Ryan Martinez', '1986-10-12', 'Male', '1234567890', '8901234567', 'ryan.martinez@example.com', 2, 3, 61000.00),
    ('NV-0012', 'Jessica Davis', '1997-08-28', 'Female', '2345678901', '4567890123', 'jessica.davis@example.com', 1, 2, 52000.00),
    ('NV-0013', 'Matthew Taylor', '1996-01-15', 'Male', '3456789012', '1234567890', 'matthew.taylor@example.com', 3, 1, 49000.00),
    ('NV-0014', 'Olivia Brown', '1993-05-20', 'Female', '4567890123', '8901234567', 'olivia.brown@example.com', 2, 3, 63000.00),
    ('NV-0015', 'Daniel Wilson', '1985-09-08', 'Male', '5678901234', '5678901234', 'daniel.wilson@example.com', 1, 2, 54000.00);


-- Insert 15 random records into the Customers table
INSERT INTO Customers ("Id", "FullName", "BirthDate", "Gender", "IdNumber", "PhoneNumber", "Email", "CustomerType", "Address")
VALUES
    ('KH-0001', 'John Doe', '1990-05-15', 'Male', '123456789012', '1234567890', 'john.doe@example.com', 1, '123 Main St'),
    ('KH-0002', 'Jane Smith', '1988-09-25', 'Female', '234567890123', '9876543210', 'jane.smith@example.com', 2, '456 Elm St'),
    ('KH-0003', 'Michael Johnson', '1995-02-10', 'Male', '345678901234', '5678901234', 'michael.johnson@example.com', 1, '789 Oak St'),
    ('KH-0004', 'Emily Brown', '1992-11-18', 'Female', '456789012345', '3456789012', 'emily.brown@example.com', 3, '101 Pine St'),
    ('KH-0005', 'David Wilson', '1987-07-07', 'Male', '567890123456', '7890123456', 'david.wilson@example.com', 2, '222 Maple St'),
    ('KH-0006', 'Sarah Garcia', '1993-04-30', 'Female', '678901234567', '2345678901', 'sarah.garcia@example.com', 1, '333 Cedar St'),
    ('KH-0007', 'James Martinez', '1991-12-22', 'Male', '789012345678', '9012345678', 'james.martinez@example.com', 3, '444 Oak St'),
    ('KH-0008', 'Linda Rodriguez', '1989-08-14', 'Female', '890123456789', '4567890123', 'linda.rodriguez@example.com', 2, '555 Elm St'),
    ('KH-0009', 'Christopher Lee', '1994-06-02', 'Male', '901234567890', '6789012345', 'christopher.lee@example.com', 3, '666 Pine St'),
    ('KH-0010', 'Amanda Harris', '1990-03-05', 'Female', '012345678901', '0123456789', 'amanda.harris@example.com', 1, '777 Maple St'),
    ('KH-0011', 'Ryan Martinez', '1986-10-12', 'Male', '123456789012', '8901234567', 'ryan.martinez@example.com', 2, '888 Cedar St'),
    ('KH-0012', 'Jessica Davis', '1997-08-28', 'Female', '234567890123', '4567890123', 'jessica.davis@example.com', 1, '999 Oak St'),
    ('KH-0013', 'Matthew Taylor', '1996-01-15', 'Male', '345678901234', '1234567890', 'matthew.taylor@example.com', 3, '1010 Elm St'),
    ('KH-0014', 'Olivia Brown', '1993-05-20', 'Female', '456789012345', '8901234567', 'olivia.brown@example.com', 2, '1111 Pine St'),
    ('KH-0015', 'Daniel Wilson', '1985-09-08', 'Male', '567890123456', '5678901234', 'daniel.wilson@example.com', 1, '1212 Maple St');