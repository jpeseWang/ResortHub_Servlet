
-- Facility

CREATE TABLE "Houses"(
    "Id" NVARCHAR(9) NOT NULL,
    "StandardRoom" NVARCHAR(255) NOT NULL,
    "Floors" INT NOT NULL
);
ALTER TABLE
    "Houses" ADD CONSTRAINT "houses_id_primary" PRIMARY KEY("Id");

CREATE TABLE "Villas"(
    "Id" NVARCHAR(9) NOT NULL,
    "StandardRoom" NVARCHAR(255) NOT NULL,
    "PoolArea" FLOAT NOT NULL,
    "Floors" INT NOT NULL
);
ALTER TABLE
    "Villas" ADD CONSTRAINT "villas_id_primary" PRIMARY KEY("Id");

CREATE TABLE "Rooms"(
    "Id" NVARCHAR(9) NOT NULL,
    "FreeService" NVARCHAR(255) NOT NULL
);
ALTER TABLE
    "Rooms" ADD CONSTRAINT "rooms_id_primary" PRIMARY KEY("Id");

CREATE TABLE "Facilities"(
    "Id" NVARCHAR(9) NOT NULL,
    "Name" NVARCHAR(255) NOT NULL,
    "Area" FLOAT NOT NULL,
    "RentalCost" DECIMAL(18, 2) NOT NULL,
    "MaxOccupancy" INT NOT NULL,
    "RentType" NVARCHAR(50) NOT NULL,
    "FacilityType" INT NOT NULL,
    "ImgSrc" NVARCHAR(255)
);
ALTER TABLE
    "Facilities" ADD CONSTRAINT "facilities_id_primary" PRIMARY KEY("Id");

ALTER TABLE "Villas" ADD CONSTRAINT "villas_facility_fk" FOREIGN KEY ("Id") REFERENCES "Facilities"("Id");
ALTER TABLE "Houses" ADD CONSTRAINT "houses_facility_fk" FOREIGN KEY ("Id") REFERENCES "Facilities"("Id");
ALTER TABLE "Rooms" ADD CONSTRAINT "rooms_facility_fk" FOREIGN KEY ("Id") REFERENCES "Facilities"("Id");

-- Customer
CREATE TABLE "Customers"(
    "Id" NVARCHAR(7) NOT NULL,
    "FullName" NVARCHAR(255) NOT NULL,
    "BirthDate" DATE NOT NULL,
    "Gender" NVARCHAR(10) NOT NULL,
    "IdNumber" NVARCHAR(12) NOT NULL,
    "PhoneNumber" NVARCHAR(10) NOT NULL,
    "Email" NVARCHAR(255) NOT NULL,
    "CustomerType" INT NOT NULL,
    "Address" NVARCHAR(255) NOT NULL
);
ALTER TABLE
    "Customers" ADD CONSTRAINT "customers_id_primary" PRIMARY KEY("Id");


-- Employee
CREATE TABLE "Employees"(
    "Id" NVARCHAR(7) NOT NULL,
    "FullName" NVARCHAR(255) NOT NULL,
    "BirthDate" DATE NOT NULL,
    "Gender" NVARCHAR(10) NOT NULL,
    "IdNumber" NVARCHAR(12) NOT NULL,
    "PhoneNumber" NVARCHAR(10) NOT NULL,
    "Email" NVARCHAR(255) NOT NULL,
    "Qualification" INT NOT NULL,
    "Position" INT NOT NULL,
    "Salary" DECIMAL(18, 2) NOT NULL
);
ALTER TABLE
    "Employees" ADD CONSTRAINT "employees_id_primary" PRIMARY KEY("Id");

-- Booking   
CREATE TABLE "Bookings"(
    "Id" INT IDENTITY(1,1) NOT NULL,
    "BookingDate" DATE NOT NULL,
    "StartDate" DATE NOT NULL,
    "EndDate" DATE NOT NULL,
    "Occupancy" INT NOT NULL,
    "RentalCost" DECIMAL(18, 2) NOT NULL,
    "ImgSrc" NVARCHAR(255),
    "CustomerId" NVARCHAR(7) NOT NULL,
    "FacilityId" NVARCHAR(9) NOT NULL,
    "ContractId" INT NOT NULL DEFAULT 0
);
ALTER TABLE
    "Bookings" ADD CONSTRAINT "bookings_id_primary" PRIMARY KEY("Id");
ALTER TABLE
    "Bookings" ADD CONSTRAINT "bookings_customerid_foreign" FOREIGN KEY("CustomerId") REFERENCES "Customers"("Id");

-- Rental Contracts
CREATE TABLE "RentalContracts"(
    "Id" INT IDENTITY(1,1) NOT NULL,
    "CustomerId" NVARCHAR(7) NOT NULL,
    "Deposit" DECIMAL(18, 2) NOT NULL,
    "TotalAmount" DECIMAL(18, 2) NOT NULL
);
ALTER TABLE
    "RentalContracts" ADD CONSTRAINT "rentalcontracts_id_primary" PRIMARY KEY("Id");

-- User    
CREATE TABLE "Users"(
    "Id" INT IDENTITY(1,1) NOT NULL,
    "Username" NVARCHAR(255) NOT NULL,
    "Password" NVARCHAR(255) NOT NULL,
    "UserRole" INT NOT NULL,
    "CustomerId" NVARCHAR(7)
);

ALTER TABLE
    "Users" ADD CONSTRAINT "users_id_primary" PRIMARY KEY("Id");

-- Update VoucherRecipientCustomers
CREATE TABLE "VoucherRecipientCustomers" (
    "Id" INT IDENTITY(1,1) NOT NULL,
    "Year" INT NOT NULL,
    "Month" INT NOT NULL,
    "CustomerId" NVARCHAR(7) NOT NULL,
    "CustomerFullName" NVARCHAR(255) NOT NULL,
    "VoucherType" INT NOT NULL
);

-- Customer Feedbacks
CREATE TABLE "CustomerFeedbacks" (
    "Id" INT IDENTITY(1,1) NOT NULL,
    "BookingId" INT NOT NULL,
    "FacilityId" NVARCHAR(9) NOT NULL, 
    "CustomerId" NVARCHAR(7) NOT NULL,
    "CustomerName" NVARCHAR(255) NOT NULL,
    "StarRating" INT NOT NULL,
    "Description" NVARCHAR(MAX) NOT NULL,
    CONSTRAINT PK_CustomerFeedbacks PRIMARY KEY ("Id")
);

-- Stories
CREATE TABLE "Stories" (
    "Id" INT IDENTITY(1,1) NOT NULL,
    "PostDate" DATE NOT NULL,
    "FacilityId" NVARCHAR(9) NOT NULL,
    "FacilityName" NVARCHAR(255) NOT NULL,
    "CustomerId" NVARCHAR(7) NOT NULL,
    "CustomerName" NVARCHAR(255) NOT NULL,
    "CustomerStatus" INT NOT NULL,
    "Title" NVARCHAR(255) NOT NULL,
    "Description" NVARCHAR(1024) NOT NULL,
    CONSTRAINT PK_Stories PRIMARY KEY ("Id")
);