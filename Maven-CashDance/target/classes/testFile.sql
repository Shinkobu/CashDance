CREATE TABLE Customers
(
    Id SERIAL PRIMARY KEY,
    Age INTEGER, 
    FirstName VARCHAR(20) NOT NULL
);
  
CREATE TABLE Orders
(
    Id SERIAL PRIMARY KEY,
    CustomerId INTEGER REFERENCES Customers (Id),
    Quantity INTEGER
);

