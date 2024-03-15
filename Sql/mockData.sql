-- Inserting 15 random records into the Employees table
INSERT INTO Employees ("Id", "FullName", "BirthDate", "Gender", "IdNumber", "PhoneNumber", "Email", "Qualification", "Position", "Salary")
VALUES
    ('NV-0001', 'John Doe', '1990-05-15', 'Male', '123456789', '0123456789', 'john.doe@example.com', 1, 2, 50000.00),
    ('NV-0002', 'Jane Smith', '1988-09-25', 'Female', '234567890', '0987654321', 'jane.smith@example.com', 2, 3, 60000.00),
    ('NV-0003', 'Michael Johnson', '1995-02-10', 'Male', '345678901', '0567890123', 'michael.johnson@example.com', 1, 1, 45000.00),
    ('NV-0004', 'Emily Brown', '1992-11-18', 'Female', '456789012', '0345678901', 'emily.brown@example.com', 3, 2, 55000.00),
    ('NV-0005', 'David Wilson', '1987-07-07', 'Male', '567890124', '0789012345', 'david.wilson@example.com', 2, 3, 62000.00),
    ('NV-0006', 'Sarah Garcia', '1993-04-30', 'Female', '678901245', '0234567890', 'sarah.garcia@example.com', 1, 2, 51000.00),
    ('NV-0007', 'James Martinez', '1991-12-22', 'Male', '789013456', '0901234567', 'james.martinez@example.com', 3, 1, 47000.00),
    ('NV-0008', 'Linda Rodriguez', '1989-08-14', 'Female', '890234567', '0456789012', 'linda.rodriguez@example.com', 2, 3, 59000.00),
    ('NV-0009', 'Christopher Lee', '1994-06-02', 'Male', '901245678', '0678901234', 'christopher.lee@example.com', 3, 2, 53000.00),
    ('NV-0010', 'Amanda Harris', '1990-03-05', 'Female', '012356789', '0123456789', 'amanda.harris@example.com', 1, 1, 48000.00),
    ('NV-0011', 'Ryan Martinez', '1986-10-12', 'Male', '123457890', '0890123456', 'ryan.martinez@example.com', 2, 3, 61000.00),
    ('NV-0012', 'Jessica Davis', '1997-08-28', 'Female', '234568901', '0456789012', 'jessica.davis@example.com', 1, 2, 52000.00),
    ('NV-0013', 'Matthew Taylor', '1996-01-15', 'Male', '345679012', '0123456789', 'matthew.taylor@example.com', 3, 1, 49000.00),
    ('NV-0014', 'Olivia Brown', '1993-05-20', 'Female', '456780123', '0890123456', 'olivia.brown@example.com', 2, 3, 63000.00),
    ('NV-0015', 'Daniel Wilson', '1985-09-08', 'Male', '567891234', '0567890123', 'daniel.wilson@example.com', 1, 2, 54000.00);


-- Insert 15 random records into the Customers table
INSERT INTO Customers ("Id", "FullName", "BirthDate", "Gender", "IdNumber", "PhoneNumber", "Email", "CustomerType", "Address")
VALUES
    ('KH-0001', 'John Doe', '1990-05-15', 'Male', '123456789', '0123456789', 'john.doe@example.com', 1, '123 Main St'),
    ('KH-0002', 'Jane Smith', '1988-09-25', 'Female', '234567890', '0987654321', 'jane.smith@example.com', 2, '456 Elm St'),
    ('KH-0003', 'Michael Johnson', '1995-02-10', 'Male', '3456789012', '0567890123', 'michael.johnson@example.com', 1, '789 Oak St'),
    ('KH-0004', 'Emily Brown', '1992-11-18', 'Female', '4567890123', '0345678901', 'emily.brown@example.com', 3, '101 Pine St'),
    ('KH-0005', 'David Wilson', '1987-07-07', 'Male', '567890123456', '0789012345', 'david.wilson@example.com', 2, '222 Maple St'),
    ('KH-0006', 'Sarah Garcia', '1993-04-30', 'Female', '678901234567', '0234567890', 'sarah.garcia@example.com', 1, '333 Cedar St'),
    ('KH-0007', 'James Martinez', '1991-12-22', 'Male', '789012345678', '0901234567', 'james.martinez@example.com', 3, '444 Oak St'),
    ('KH-0008', 'Linda Rodriguez', '1989-08-14', 'Female', '890123456789', '0456789012', 'linda.rodriguez@example.com', 2, '555 Elm St'),
    ('KH-0009', 'Christopher Lee', '1994-06-02', 'Male', '901234567890', '0678901234', 'christopher.lee@example.com', 3, '666 Pine St'),
    ('KH-0010', 'Amanda Harris', '1990-03-05', 'Female', '012345678901', '0012345678', 'amanda.harris@example.com', 1, '777 Maple St'),
    ('KH-0011', 'Ryan Martinez', '1986-10-12', 'Male', '123456789012', '0890123456', 'ryan.martinez@example.com', 2, '888 Cedar St'),
    ('KH-0012', 'Jessica Davis', '1997-08-28', 'Female', '234567890123', '0456789012', 'jessica.davis@example.com', 1, '999 Oak St'),
    ('KH-0013', 'Matthew Taylor', '1996-01-15', 'Male', '345678901234', '0123456789', 'matthew.taylor@example.com', 3, '1010 Elm St'),
    ('KH-0014', 'Olivia Brown', '1993-05-20', 'Female', '456789012345', '0890123456', 'olivia.brown@example.com', 2, '1111 Pine St'),
    ('KH-0015', 'Daniel Wilson', '1985-09-08', 'Male', '567890123456', '0567890123', 'daniel.wilson@example.com', 1, '1212 Maple St');


-- Insert 15 random user and admin records 
INSERT INTO Users (Username, Password, UserRole, CustomerId) VALUES 
('admin1', 'admin1', 1, 'KH-0000'),
('admin2', 'admin2', 1, 'KH-0000'),
('user1', 'user1', 2, 'KH-0001'),
('user2', 'user2', 2, 'KH-0002');


-- Mock data for VILLA
INSERT INTO Facilities (Id, Name, Area, RentalCost, MaxOccupancy, RentType, FacilityType, ImgSrc) 
VALUES 
('SVVL-0000', 'Luxury Paradise Resort', 260.0, 150, 15, 'Deluxe', 1, 'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dmlsbGF8ZW58MHx8MHx8fDA%3D'),
('SVVL-0001', 'Seaside Grand Hotel', 300.0, 200, 18, 'Standard', 1, 'https://images.unsplash.com/photo-1582268611958-ebfd161ef9cf?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8dmlsbGF8ZW58MHx8MHx8fDA%3D'),
('SVVL-0002', 'Palm View Retreat', 350.0, 180, 12, 'Standard', 1, 'https://images.unsplash.com/photo-1564013799919-ab600027ffc6?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8dmlsbGF8ZW58MHx8MHx8fDA%3D'),
('SVVL-0003', 'Mountain Valley Lodge', 280.0, 170, 14, 'Deluxe', 1, 'https://plus.unsplash.com/premium_photo-1661963657305-f52dcaeef418?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8dmlsbGF8ZW58MHx8MHx8fDA%3D'),
('SVVL-0004', 'Serenity Hills Resort', 320.0, 190, 16, 'Deluxe', 1, 'https://images.unsplash.com/photo-1626249893783-cc4a9f66880a?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHZpbGxhfGVufDB8MHwwfHx8MA%3D%3D'),
('SVVL-0005', 'Tropical Breeze Inn', 270.0, 160, 11, 'Standard', 1, 'https://images.unsplash.com/photo-1568605115459-4b731184f961?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjd8fHZpbGxhfGVufDB8MHwwfHx8MA%3D%3D'),
('SVVL-0006', 'Sunset Cove Villas', 310.0, 220, 19, 'Deluxe', 1, 'https://plus.unsplash.com/premium_photo-1681922761181-ee59fa91edc7?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjl8fHZpbGxhfGVufDB8MHwwfHx8MA%3D%3D'),
('SVVL-0007', 'Harbor View Resort', 340.0, 210, 17, 'Standard', 1, 'https://images.unsplash.com/photo-1613553507747-5f8d62ad5904?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzF8fHZpbGxhfGVufDB8MHwwfHx8MA%3D%3D'),
('SVVL-0008', 'Riverside Retreat', 290.0, 175, 13, 'Standard', 1, 'https://images.unsplash.com/photo-1600607688969-a5bfcd646154?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDJ8fHZpbGxhfGVufDB8MHwwfHx8MA%3D%3D'),
('SVVL-0009', 'Lakefront Lodge', 330.0, 230, 20, 'Deluxe', 1, 'https://images.unsplash.com/photo-1565731761817-6bdc8e7d9f34?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDN8fHZpbGxhfGVufDB8MHwwfHx8MA%3D%3D'),
('SVVL-0010', 'Hyatt Rergene', 330.0, 230, 20, 'Deluxe', 1, 'https://images.unsplash.com/photo-1565731761817-6bdc8e7d9f34?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDN8fHZpbGxhfGVufDB8MHwwfHx8MA%3D%3D');

INSERT INTO Villas (Id, StandardRoom, PoolArea, Floors) 
VALUES 
('SVVL-0000', 'Normal', 36.0, 6),
('SVVL-0001', 'Normal', 56.0, 6),
('SVVL-0002', 'Superior', 40.0, 4),
('SVVL-0003', 'Luxury', 70.0, 7),
('SVVL-0004', 'Normal', 35.0, 5),
('SVVL-0005', 'Superior', 60.0, 3),
('SVVL-0006', 'Luxury', 45.0, 8),
('SVVL-0007', 'Normal', 50.0, 6),
('SVVL-0008', 'Superior', 55.0, 4),
('SVVL-0009', 'Luxury', 65.0, 7),
('SVVL-0010', 'Normal', 30.0, 5);


-- Mock data for HOUSE
INSERT INTO Facilities (Id, Name, Area, RentalCost, MaxOccupancy, RentType, FacilityType, ImgSrc) 
VALUES 
('SVHO-0000', 'Mystic Oasis Retreat', 260.0, 150, 15, 'Deluxe', 2, 'https://images.unsplash.com/photo-1570129477492-45c003edd2be?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aG91c2V8ZW58MHwwfDB8fHww'),
('SVHO-0001', 'Whispering Waves', 300.0, 200, 18, 'Standard', 2, 'https://images.unsplash.com/photo-1582063289852-62e3ba2747f8?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjZ8fGhvdXNlfGVufDB8MHwwfHx8MA%3D%3D'),
('SVHO-0002', 'Golden Sunset Retreat', 350.0, 180, 12, 'Standard', 2, 'https://images.unsplash.com/photo-1625602812206-5ec545ca1231?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mzl8fGhvdXNlfGVufDB8MHwwfHx8MA%3D%3D'),
('SVHO-0003', 'Evergreen Haven Lodge', 280.0, 170, 14, 'Deluxe', 2, 'https://images.unsplash.com/photo-1571939228382-b2f2b585ce15?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzR8fGhvdXNlfGVufDB8MHwwfHx8MA%3D%3D'),
('SVHO-0004', 'Azure Bliss Resort', 320.0, 190, 16, 'Deluxe', 2, 'https://images.unsplash.com/photo-1588880331179-bc9b93a8cb5e?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTJ8fGhvdXNlfGVufDB8MHwwfHx8MA%3D%3D'),
('SVHO-0005', 'Tropical Breeze Inn', 270.0, 160, 11, 'Standard', 2, 'https://images.unsplash.com/photo-1591474200742-8e512e6f98f8?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTB8fGhvdXNlfGVufDB8MHwwfHx8MA%3D%3D');

INSERT INTO Houses (Id, StandardRoom, Floors) 
VALUES 
('SVHO-0000', 'Luxury',  3),
('SVHO-0001', 'Normal',  6),
('SVHO-0002', 'Superior', 4),
('SVHO-0003', 'Luxury', 7),
('SVHO-0004', 'Normal', 5),
('SVHO-0005', 'Superior', 3);



-- Mock data for ROOM
INSERT INTO Facilities (Id, Name, Area, RentalCost, MaxOccupancy, RentType, FacilityType, ImgSrc) 
VALUES 
('SVRO-0000', 'Elegant Suite', 260.0, 150, 15, 'Deluxe', 3, 'https://plus.unsplash.com/premium_photo-1678752717095-08cd0bd1d7e7?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cm9vbXxlbnwwfDB8MHx8fDA%3D'),
('SVRO-0001', 'Oceanview Retreat', 300.0, 200, 18, 'Standard', 3, 'https://plus.unsplash.com/premium_photo-1674676471380-1258cb31b3ac?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cm9vbXxlbnwwfDB8MHx8fDA%3D'),
('SVRO-0002', 'Palm Oasis', 350.0, 180, 12, 'Standard', 3, 'https://images.unsplash.com/photo-1598928506311-c55ded91a20c?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8cm9vbXxlbnwwfDB8MHx8fDA%3D'),
('SVRO-0003', 'Mountain View Cabin', 280.0, 170, 14, 'Deluxe', 3, 'https://plus.unsplash.com/premium_photo-1663126298656-33616be83c32?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fHJvb218ZW58MHwwfDB8fHww'),
('SVRO-0004', 'Serenity Suite', 320.0, 190, 16, 'Deluxe', 3, 'https://plus.unsplash.com/premium_photo-1676823553207-758c7a66e9bb?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fHJvb218ZW58MHwwfDB8fHww'),
('SVRO-0005', 'Tropical Paradise Room', 270.0, 160, 11, 'Standard', 3, 'https://images.unsplash.com/photo-1537726235470-8504e3beef77?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjJ8fHJvb218ZW58MHwwfDB8fHww');

INSERT INTO Rooms (Id, FreeService) 
VALUES 
('SVRO-0000', 'Mini Bar'),
('SVRO-0001', 'Wi-Fi Access'),
('SVRO-0002', 'Private Balcony'),
('SVRO-0003', 'Jacuzzi Tub'),
('SVRO-0004', 'Complimentary Breakfast'),
('SVRO-0005', 'Ocean View');
