LOCK TABLES `bank_user` WRITE;
/*!40000 ALTER TABLE `bank_user` DISABLE KEYS */;
INSERT INTO `bank_user` VALUES ('8a85867e6ad9e761016ada958bdf5b0f','ROLE_USER','{bcrypt}$2a$10$NChup2Jtn0AwCsd2rNl4mOviSz6XtePgaBVJoSX5AiBRyB4dpqnHe','user2'),('8a8587b371776b9e01717d217e6e1492','ROLE_USER','{bcrypt}$2a$10$otWOwYQfXNshFxajzXfteeHB70WuDHmvV8XcpqIIBGw.CuCZSRwNu','user1'),('8a8587fd6b0487a7016b07a1ecfb0b74','ROLE_USER','{bcrypt}$2a$10$XQB0fxEOe0SchA/5L0dwmeUtTxyju3cHOMlOLdIg4GIY33sqSyKLS','user3');
/*!40000 ALTER TABLE `bank_user` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `transaction_fees` WRITE;
/*!40000 ALTER TABLE `transaction_fees` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_fees` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES ('1176',1600,0,0,0,100,0,0,0,0,0,100,'8a8587376ad96493016ada758e6208e6','2023-04-07T08:42:41+02:00','EUR','8a8586427147b0b101714fe18b0942f0','8a8587506b566dfd016b5add799444ec','8a8586427147b0b101714fe18b0942ee','DEPOSIT','2023-04-07T08:42:41+02:00','8a8587fd6b0487a7016b07a1ecfb0b74'),('1205',1587.5,0,0,0,12.5,0,0,0,0,0,-12.5,'8a8587376ad96493016ada758e6208e6','2023-04-08T15:08:49+02:00','EUR','8a85866f7155205601715987552476ec','8a8587506b566dfd016b5add799444ec','8a85866f7155205601715987552476ee','TRANSFER','2023-04-08T15:08:49+02:00','8a85867e6ad9e761016ada958bdf5b0f'),('1207',1562.5,0,0,0,25,0,0,0,0,0,-25,'8a8587376ad96493016ada758e6208e6','2023-04-08T15:27:24+02:00','EUR','8a85879c715957a6017159875482105a','8a8587506b566dfd016b5add799444ec','8a85879c715957a6017159875482105c','TRANSFER','2023-04-08T15:27:24+02:00','8a85867e6ad9e761016ada958bdf5b0f'),('1243',1762.5,0,0,0,200,0,0,0,0,0,200,'8a8587376ad96493016ada758e6208e6','2023-04-10T11:31:18+02:00','EUR','8a8587f7715f08260171636de170588f','8a8587506b566dfd016b5add799444ec','8a8587f7715f08260171633cb3bc525f','DEPOSIT','2023-04-10T11:31:18+02:00','8a85867e6ad9e761016ada958bdf5b0f'),('1252',1712.5,0,0,0,50,0,0,0,0,0,-50,'8a8587376ad96493016ada758e6208e6','2023-04-10T14:41:24+02:00','EUR','8a8587d8715f11960171641114d26003','8a8587506b566dfd016b5add799444ec','8a8587d8715f11960171641bee036020','TRANSFER','2023-04-10T14:41:24+02:00','8a85867e6ad9e761016ada958bdf5b0f'),('1307',1691,0,0,0,21.5,0,0,0,0,0,-21.5,'8a8587376ad96493016ada758e6208e6','2023-04-17T14:26:07+02:00','EUR','8a85871771857bc501718816e2c808ce','8a8587506b566dfd016b5add799444ec','8a85871771857bc50171881a73910a76','TRANSFER','2023-04-17T14:26:07+02:00','8a8587b371776b9e01717d217e6e1492'),('1309',1679.89,0,0,0,11.11,0,0,0,0,0,-11.11,'8a8587376ad96493016ada758e6208e6','2023-04-17T15:02:39+02:00','EUR','8a8586c5718588a20171881b4bc86de3','8a8587506b566dfd016b5add799444ec','8a8586c5718588a20171883be60f760c','TRANSFER','2023-04-17T15:02:39+02:00','8a8587b371776b9e01717d217e6e1492'),('371',250,0,0,0,250,0,0,0,0,0,250,'8a8587376ad96493016ada758e6208e6','2022-06-15T13:22:43+02:00','EUR','8a8587506b566dfd016b5adf5d4444f0','8a8587506b566dfd016b5add799444ec',NULL,'DEPOSIT','2022-05-01T00:00:00+02:00','8a8587fd6b0487a7016b07a1ecfb0b74'),('372',100,0,0,0,150,0,0,0,0,0,-150,'8a8587376ad96493016ada758e6208e6','2022-06-15T13:22:57+02:00','EUR','8a8587506b566dfd016b5ae0492944f2','8a8587506b566dfd016b5add799444ec',NULL,'WITHDRAWAL','2022-05-03T00:00:00+02:00','8a8587fd6b0487a7016b07a1ecfb0b74'),('373',500,0,0,0,400,0,0,0,0,0,400,'8a8587376ad96493016ada758e6208e6','2022-06-15T13:23:46+02:00','EUR','8a8587506b566dfd016b5ae0492944f4','8a8587506b566dfd016b5add799444ec',NULL,'DEPOSIT','2022-05-07T00:00:00+02:00','8a8587fd6b0487a7016b07a1ecfb0b74'),('374',250,0,0,0,250,0,0,0,0,0,-250,'8a8587376ad96493016ada758e6208e6','2022-06-15T13:24:07+02:00','EUR','8a8587506b566dfd016b5ae0492944f6','8a8587506b566dfd016b5add799444ec',NULL,'WITHDRAWAL','2022-05-08T00:00:00+02:00','8a8587fd6b0487a7016b07a1ecfb0b74'),('375',2250,0,0,0,2000,0,0,0,0,0,2000,'8a8587376ad96493016ada758e6208e6','2022-06-15T13:24:37+02:00','EUR','8a8587506b566dfd016b5ae15b6644f8','8a8587506b566dfd016b5add799444ec',NULL,'DEPOSIT','2022-05-10T00:00:00+02:00','8a8587fd6b0487a7016b07a1ecfb0b74'),('376',1550,0,0,0,700,0,0,0,0,0,-700,'8a8587376ad96493016ada758e6208e6','2022-06-15T13:25:16+02:00','EUR','8a8587506b566dfd016b5ae15b6644fa','8a8587506b566dfd016b5add799444ec','8a8587506b566dfd016b5ae26a9344fc','TRANSFER','2022-06-15T13:25:16+02:00','8a8587fd6b0487a7016b07a1ecfb0b74'),('378',1500,0,0,0,50,0,0,0,0,0,-50,'8a8587376ad96493016ada758e6208e6','2022-06-15T13:25:35+02:00','EUR','8a8587506b566dfd016b5ae26a9344fe','8a8587506b566dfd016b5add799444ec',NULL,'TRANSFER','2022-06-15T13:25:35+02:00','8a8587fd6b0487a7016b07a1ecfb0b74');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;


