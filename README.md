# PointOfSale

Sample MVC project implementing a simple point of sale which consists of:
- one input device: bar-code scanner (represented by two classes: BarcodeScanner and ExitButton)
- two output devices: LCD display and printer

Input devices send appropriate events to controller by putting them into a blocking queue.
Controller takes events from the blocking queue and handle them by mapping event types to event strategies and executing proper strategies.
Event strategies can modify the model or throw exceptions, depending on the given input.
The model communicates with database to get products' data and stores it in the Receipt.
Model is observed by two views:
- LCD display which is responsible for displaying name and price of a latest scanned product as well as displaying the total sum to be paid, when all the products are scanned,
- printer which is responsible for printing the receipt.
