# OrdersTestApp

Test application that returns random number of tomato orders. The application uses Spring MVC.

Each order should have:
- id: randomly generated UUID
- tomatoes: randomly generated number from 1 to 2000
- provider: randomly generated String, one of the following: "Heinz", "Hunt's", "Del Monte", "Le Ol' Granma"
- timestamp: randomly generated long from the begging of this year to today

The application accepts POST/GET requests on <endpoint>/data?size=<X>, where the size parameter is optional. Size of returned data is governed by the size param.
The size defaults to 3.