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
CREATE TABLE "RentalContracts"(
    "Id" INT NOT NULL,
    "BookingId" INT NOT NULL,
    "Deposit" DECIMAL(18, 2) NOT NULL,
    "TotalAmount" DECIMAL(18, 2) NOT NULL
);
ALTER TABLE
    "RentalContracts" ADD CONSTRAINT "rentalcontracts_id_primary" PRIMARY KEY("Id");
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
CREATE TABLE "Facilities"(
    "Id" NVARCHAR(9) NOT NULL,
    "Name" NVARCHAR(255) NOT NULL,
    "Area" FLOAT NOT NULL,
    "RentalCost" DECIMAL(18, 2) NOT NULL,
    "MaxOccupancy" INT NOT NULL,
    "RentType" NVARCHAR(50) NOT NULL,
    "FacilityType" INT NOT NULL
);
ALTER TABLE
    "Facilities" ADD CONSTRAINT "facilities_id_primary" PRIMARY KEY("Id");
-- Foreign key constraints with ON DELETE CASCADE

ALTER TABLE "Facilities" ADD CONSTRAINT "facilities_villa_foreign" FOREIGN KEY ("Id") REFERENCES "Villas" ("Id") ON DELETE CASCADE;
ALTER TABLE "Facilities" ADD CONSTRAINT "facilities_house_foreign" FOREIGN KEY ("Id") REFERENCES "Houses" ("Id") ON DELETE CASCADE;
ALTER TABLE "Facilities" ADD CONSTRAINT "facilities_room_foreign" FOREIGN KEY ("Id") REFERENCES "Rooms" ("Id") ON DELETE CASCADE;

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
CREATE TABLE "Bookings"(
    "Id" INT NOT NULL,
    "BookingDate" DATE NOT NULL,
    "StartDate" DATE NOT NULL,
    "EndDate" DATE NOT NULL,
    "CustomerId" NVARCHAR(7) NOT NULL,
    "FacilityId" NVARCHAR(9) NOT NULL
);
ALTER TABLE
    "Bookings" ADD CONSTRAINT "bookings_id_primary" PRIMARY KEY("Id");
CREATE TABLE "Users"(
    "Id" INT NOT NULL,
    "Username" NVARCHAR(255) NOT NULL,
    "Password" NVARCHAR(255) NOT NULL,
    "UserRole" INT NOT NULL
);
ALTER TABLE
    "Users" ADD CONSTRAINT "users_id_primary" PRIMARY KEY("Id");
CREATE TABLE "Rooms"(
    "Id" NVARCHAR(9) NOT NULL,
    "FreeService" NVARCHAR(255) NOT NULL
);
ALTER TABLE
    "Rooms" ADD CONSTRAINT "rooms_id_primary" PRIMARY KEY("Id");
ALTER TABLE
    "Bookings" ADD CONSTRAINT "bookings_customerid_foreign" FOREIGN KEY("CustomerId") REFERENCES "Customers"("Id");
ALTER TABLE
    "RentalContracts" ADD CONSTRAINT "rentalcontracts_bookingid_foreign" FOREIGN KEY("BookingId") REFERENCES "Bookings"("Id");
ALTER TABLE
    "Facilities" ADD CONSTRAINT "facilities_id_foreign" FOREIGN KEY("Id") REFERENCES "Villas"("Id");
ALTER TABLE
    "Facilities" ADD CONSTRAINT "facilities_id_foreign" FOREIGN KEY("Id") REFERENCES "Houses"("Id");
ALTER TABLE
    "Facilities" ADD CONSTRAINT "facilities_id_foreign" FOREIGN KEY("Id") REFERENCES "Rooms"("Id");