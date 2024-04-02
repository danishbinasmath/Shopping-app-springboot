Entity-Relationship (ER) Diagram:
sql
Copy code
  +-------------------+       +---------------------+
  |      User         |       |      Product        |
  +-------------------+       +---------------------+
  | userId: Long (PK)|       | productId: Long (PK)|
  | username: String  |       | name: String        |
  +-------------------+       | price: BigDecimal   |
                               | availableQuantity: Integer |
                               +---------------------+
Class Diagram:
sql
+-----------------------------------+
|             UserService           |
+-----------------------------------+
| + getUserById(Long userId): User |
+-----------------------------------+
                     |
                     |
                     v
+-----------------------------------+
|          UserServiceImpl          |
+-----------------------------------+
| + getUserById(Long userId): User |
+-----------------------------------+
                     |
                     |
                     v
+-----------------------------------+
|              User                 |
+-----------------------------------+
| userId: Long                     |
| username: String                 |
+-----------------------------------+
                     ^
                     |
                     |
+-----------------------------------+
|          ProductService           |
+-----------------------------------+
| + fetchProductDetails(): Product  |
| + fetchCoupons(): Map<String, Integer> |
| + placeOrder(Long userId, int quantity, String couponCode): String |
+-----------------------------------+
                     |
                     |
                     v
+-----------------------------------+
|         ProductServiceImpl        |
+-----------------------------------+
| + fetchProductDetails(): Product  |
| + fetchCoupons(): Map<String, Integer> |
| + placeOrder(Long userId, int quantity, String couponCode): String |
+-----------------------------------+
                     |
                     |
                     v
+-----------------------------------+
|            Product                |
+-----------------------------------+
| productId: Long                  |
| name: String                     |
| price: BigDecimal                |
| availableQuantity: Integer       |
+-----------------------------------+
