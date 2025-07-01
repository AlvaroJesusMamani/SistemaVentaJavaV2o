USE [BDSistVentas]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 30/06/2025 21:13:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[id_cliente] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](100) NULL,
	[telefono] [nvarchar](20) NULL,
	[email] [nvarchar](100) NULL,
	[direccion_calle] [nvarchar](100) NULL,
	[direccion_av] [nvarchar](100) NULL,
	[direccion_mz] [nvarchar](50) NULL,
	[ciudad] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetalleVenta]    Script Date: 30/06/2025 21:13:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleVenta](
	[id_venta] [int] NULL,
	[id_producto] [int] NULL,
	[cantidad] [int] NULL,
	[precioUnitario] [decimal](10, 2) NULL,
	[importe]  AS ([cantidad]*[precioUnitario]) PERSISTED,
	[id_detalle] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_detalle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Empleado]    Script Date: 30/06/2025 21:13:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Empleado](
	[id_empleado] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](100) NULL,
	[telefono] [nvarchar](20) NULL,
	[dni] [nvarchar](20) NULL,
	[email] [nvarchar](100) NULL,
	[direccion_calle] [nvarchar](100) NULL,
	[direccion_av] [nvarchar](100) NULL,
	[direccion_mz] [nvarchar](50) NULL,
	[ciudad] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_empleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Producto]    Script Date: 30/06/2025 21:13:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producto](
	[id_producto] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [nvarchar](255) NULL,
	[precio] [decimal](10, 2) NULL,
	[categoria] [nvarchar](100) NULL,
	[fechaVencimiento] [date] NULL,
	[id_proveedor] [int] NULL,
	[codigo] [nvarchar](50) NOT NULL,
	[stock] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_producto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Proveedor]    Script Date: 30/06/2025 21:13:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proveedor](
	[id_proveedor] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](100) NULL,
	[telefono] [nvarchar](20) NULL,
	[direccion_calle] [nvarchar](100) NULL,
	[direccion_av] [nvarchar](100) NULL,
	[direccion_mz] [nvarchar](50) NULL,
	[RUC] [nvarchar](20) NULL,
	[email] [nvarchar](100) NULL,
	[fechaRegistro] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_proveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Venta]    Script Date: 30/06/2025 21:13:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Venta](
	[id_venta] [int] IDENTITY(1,1) NOT NULL,
	[fechaVenta] [date] NULL,
	[metodoPago] [nvarchar](50) NULL,
	[id_empleado] [int] NULL,
	[id_cliente] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_venta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Cliente] ON 
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (1, N'Carlos Ramírez', N'912345678', N'carlos@mail.com', N'Calle Lima', N'Av. Perú', N'MZ A1', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (2, N'María Torres', N'912345679', N'maria@mail.com', N'Calle Arequipa', N'Av. Brasil', N'MZ A2', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (3, N'Pedro Gómez', N'912345680', N'pedro@mail.com', N'Calle Cusco', N'Av. Argentina', N'MZ A3', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (4, N'Ana Flores', N'912345681', N'ana@mail.com', N'Calle Piura', N'Av. Venezuela', N'MZ A4', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (5, N'Luis Huamán', N'912345682', N'luis@mail.com', N'Calle Ica', N'Av. Bolivia', N'MZ A5', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (6, N'Rosa Chávez', N'912345683', N'rosa@mail.com', N'Calle Tacna', N'Av. Chile', N'MZ A6', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (7, N'Julio Salazar', N'912345684', N'julio@mail.com', N'Calle Puno', N'Av. Ecuador', N'MZ A7', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (8, N'Lucía Soto', N'912345685', N'lucia@mail.com', N'Calle Loreto', N'Av. Argentina', N'MZ A8', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (9, N'Oscar Pérez', N'912345686', N'oscar@mail.com', N'Calle Huánuco', N'Av. México', N'MZ A9', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (10, N'Sandra Quispe', N'912345687', N'sandra@mail.com', N'Calle Ayacucho', N'Av. Canadá', N'MZ A10', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (11, N'Hugo Romero', N'912345688', N'hugo@mail.com', N'Calle Junín', N'Av. Brasil', N'MZ A11', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (12, N'Carmen Medina', N'912345689', N'carmen@mail.com', N'Calle Cajamarca', N'Av. Perú', N'MZ A12', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (13, N'Raúl Vargas', N'912345690', N'raul@mail.com', N'Calle Ancash', N'Av. Chile', N'MZ A13', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (14, N'Diana Silva', N'912345691', N'diana@mail.com', N'Calle Apurímac', N'Av. Argentina', N'MZ A14', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (15, N'Ricardo León', N'912345692', N'ricardo@mail.com', N'Calle Moquegua', N'Av. Brasil', N'MZ A15', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (16, N'Angela Ruiz', N'912345693', N'angela@mail.com', N'Calle Amazonas', N'Av. México', N'MZ A16', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (17, N'Fernando Díaz', N'912345694', N'fernando@mail.com', N'Calle Madre de Dios', N'Av. Bolivia', N'MZ A17', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (18, N'Jessica Gutiérrez', N'912345695', N'jessica@mail.com', N'Calle Ucayali', N'Av. Venezuela', N'MZ A18', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (19, N'Martín Cáceres', N'912345696', N'martin@mail.com', N'Calle Tumbes', N'Av. Ecuador', N'MZ A19', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (20, N'Patricia Valdez', N'912345697', N'patricia@mail.com', N'Calle San Martín', N'Av. Canadá', N'MZ A20', N'Lima')
GO
INSERT [dbo].[Cliente] ([id_cliente], [nombre], [telefono], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (21, N'Alvaro Jesus', N'987456123', N'alvaro@gmail.com', N'Calle Lima', N'Av. brasil', N'Mz a45', N'Lima')
GO
SET IDENTITY_INSERT [dbo].[Cliente] OFF
GO
SET IDENTITY_INSERT [dbo].[DetalleVenta] ON 
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (1, 1, 2, CAST(4.50 AS Decimal(10, 2)), 1)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (2, 2, 1, CAST(3.20 AS Decimal(10, 2)), 2)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (3, 3, 3, CAST(4.80 AS Decimal(10, 2)), 3)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (4, 4, 2, CAST(5.00 AS Decimal(10, 2)), 4)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (5, 5, 1, CAST(6.00 AS Decimal(10, 2)), 5)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (6, 6, 4, CAST(2.50 AS Decimal(10, 2)), 6)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (7, 7, 2, CAST(3.50 AS Decimal(10, 2)), 7)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (8, 8, 1, CAST(6.00 AS Decimal(10, 2)), 8)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (9, 9, 3, CAST(5.20 AS Decimal(10, 2)), 9)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (10, 10, 2, CAST(12.00 AS Decimal(10, 2)), 10)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (11, 11, 2, CAST(10.50 AS Decimal(10, 2)), 11)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (12, 12, 5, CAST(2.30 AS Decimal(10, 2)), 12)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (13, 13, 4, CAST(1.50 AS Decimal(10, 2)), 13)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (14, 14, 2, CAST(7.80 AS Decimal(10, 2)), 14)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (15, 15, 1, CAST(4.20 AS Decimal(10, 2)), 15)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (16, 16, 3, CAST(6.50 AS Decimal(10, 2)), 16)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (17, 17, 1, CAST(14.00 AS Decimal(10, 2)), 17)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (18, 18, 2, CAST(5.00 AS Decimal(10, 2)), 18)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (19, 19, 4, CAST(2.80 AS Decimal(10, 2)), 19)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (20, 20, 6, CAST(3.00 AS Decimal(10, 2)), 20)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (27, 2, 1, CAST(3.20 AS Decimal(10, 2)), 21)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (28, 2, 1, CAST(3.20 AS Decimal(10, 2)), 22)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (29, 1, 1, CAST(4.50 AS Decimal(10, 2)), 23)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (24, 3, 1, CAST(4.80 AS Decimal(10, 2)), 24)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (25, 20, 2, CAST(3.00 AS Decimal(10, 2)), 25)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (26, 11, 1, CAST(10.50 AS Decimal(10, 2)), 26)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (26, 17, 1, CAST(14.00 AS Decimal(10, 2)), 27)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (21, 3, 1, CAST(4.80 AS Decimal(10, 2)), 28)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (22, 11, 1, CAST(10.50 AS Decimal(10, 2)), 29)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (22, 10, 1, CAST(12.00 AS Decimal(10, 2)), 30)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (23, 1, 2, CAST(4.50 AS Decimal(10, 2)), 31)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (31, 2, 1, CAST(3.20 AS Decimal(10, 2)), 32)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (31, 2, 1, CAST(3.20 AS Decimal(10, 2)), 33)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (32, 1, 1, CAST(4.50 AS Decimal(10, 2)), 34)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (32, 4, 2, CAST(5.50 AS Decimal(10, 2)), 35)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (33, 5, 1, CAST(6.00 AS Decimal(10, 2)), 36)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (33, 7, 1, CAST(3.50 AS Decimal(10, 2)), 37)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (34, 2, 1, CAST(3.20 AS Decimal(10, 2)), 38)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (34, 8, 1, CAST(6.00 AS Decimal(10, 2)), 39)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (35, 4, 1, CAST(5.50 AS Decimal(10, 2)), 40)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (36, 8, 1, CAST(6.00 AS Decimal(10, 2)), 41)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (36, 7, 2, CAST(3.50 AS Decimal(10, 2)), 42)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (37, 9, 1, CAST(5.20 AS Decimal(10, 2)), 43)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (38, 8, 1, CAST(6.00 AS Decimal(10, 2)), 44)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (39, 7, 1, CAST(3.50 AS Decimal(10, 2)), 45)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (40, 7, 1, CAST(3.50 AS Decimal(10, 2)), 46)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (41, 4, 1, CAST(5.50 AS Decimal(10, 2)), 47)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (42, 4, 1, CAST(5.50 AS Decimal(10, 2)), 48)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (43, 9, 1, CAST(5.20 AS Decimal(10, 2)), 49)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (44, 8, 1, CAST(6.00 AS Decimal(10, 2)), 50)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (44, 1, 1, CAST(4.50 AS Decimal(10, 2)), 51)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (45, 8, 1, CAST(6.00 AS Decimal(10, 2)), 52)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (46, 20, 1, CAST(3.00 AS Decimal(10, 2)), 53)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (46, 17, 2, CAST(14.00 AS Decimal(10, 2)), 54)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (47, 2, 1, CAST(3.20 AS Decimal(10, 2)), 55)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (47, 12, 1, CAST(2.30 AS Decimal(10, 2)), 56)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (47, 9, 2, CAST(5.20 AS Decimal(10, 2)), 57)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (48, 14, 1, CAST(7.80 AS Decimal(10, 2)), 58)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (48, 16, 2, CAST(6.50 AS Decimal(10, 2)), 59)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (48, 5, 4, CAST(6.00 AS Decimal(10, 2)), 60)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (48, 7, 1, CAST(3.50 AS Decimal(10, 2)), 61)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (49, 5, 1, CAST(6.00 AS Decimal(10, 2)), 62)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (49, 1, 1, CAST(4.50 AS Decimal(10, 2)), 63)
GO
INSERT [dbo].[DetalleVenta] ([id_venta], [id_producto], [cantidad], [precioUnitario], [id_detalle]) VALUES (50, 8, 1, CAST(6.00 AS Decimal(10, 2)), 1055)
GO
SET IDENTITY_INSERT [dbo].[DetalleVenta] OFF
GO
SET IDENTITY_INSERT [dbo].[Empleado] ON 
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (1, N'Jose Ramos', N'913000001', N'12345671', N'jose@mail.com', N'Calle Uno', N'Av. Uno', N'MZ B1', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (2, N'Luciana Díaz', N'913000002', N'12345672', N'luciana@mail.com', N'Calle Dos', N'Av. Dos', N'MZ B2', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (3, N'Alonso Cueva', N'913000003', N'12345673', N'alonso@mail.com', N'Calle Tres', N'Av. Tres', N'MZ B3', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (4, N'Mario Rivera', N'913000004', N'12345674', N'mario@mail.com', N'Calle Cuatro', N'Av. Cuatro', N'MZ B4', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (5, N'Daniela Meza', N'913000005', N'12345675', N'daniela@mail.com', N'Calle Cinco', N'Av. Cinco', N'MZ B5', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (6, N'Sandra León', N'913000006', N'12345676', N'sandra@mail.com', N'Calle Seis', N'Av. Seis', N'MZ B6', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (7, N'Carlos Ruiz', N'913000007', N'12345677', N'carlosr@mail.com', N'Calle Siete', N'Av. Siete', N'MZ B7', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (8, N'Vanessa Torres', N'913000008', N'12345678', N'vanessa@mail.com', N'Calle Ocho', N'Av. Ocho', N'MZ B8', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (9, N'Oscar Peña', N'913000009', N'12345679', N'oscarp@mail.com', N'Calle Nueve', N'Av. Nueve', N'MZ B9', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (10, N'Gabriela Soto', N'913000010', N'12345680', N'gabriela@mail.com', N'Calle Diez', N'Av. Diez', N'MZ B10', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (11, N'Luis Castro', N'913000011', N'12345681', N'luisc@mail.com', N'Calle 11', N'Av. 11', N'MZ B11', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (12, N'Estefanía Ramos', N'913000012', N'12345682', N'estefania@mail.com', N'Calle 12', N'Av. 12', N'MZ B12', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (13, N'Renato Vidal', N'913000013', N'12345683', N'renato@mail.com', N'Calle 13', N'Av. 13', N'MZ B13', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (14, N'Tania Zapata', N'913000014', N'12345684', N'tania@mail.com', N'Calle 14', N'Av. 14', N'MZ B14', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (15, N'Eduardo Quispe', N'913000015', N'12345685', N'eduardo@mail.com', N'Calle 15', N'Av. 15', N'MZ B15', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (16, N'Pamela Aguilar', N'913000016', N'12345686', N'pamela@mail.com', N'Calle 16', N'Av. 16', N'MZ B16', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (17, N'Miguel Vargas', N'913000017', N'12345687', N'miguel@mail.com', N'Calle 17', N'Av. 17', N'MZ B17', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (18, N'Lorena Medina', N'913000018', N'12345688', N'lorena@mail.com', N'Calle 18', N'Av. 18', N'MZ B18', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (19, N'Andrés Salas', N'913000019', N'12345689', N'andres@mail.com', N'Calle 19', N'Av. 19', N'MZ B19', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (20, N'Natalia Bravo', N'913000020', N'12345690', N'natalia@mail.com', N'Calle 20', N'Av. 20', N'MZ B20', N'Lima')
GO
INSERT [dbo].[Empleado] ([id_empleado], [nombre], [telefono], [dni], [email], [direccion_calle], [direccion_av], [direccion_mz], [ciudad]) VALUES (21, N'Alvaro', N'963258111', N'60777560', N'alvaro@gmail.com', N'Lima', N'Av. Brasil', N'Mz A', N'Lima')
GO
SET IDENTITY_INSERT [dbo].[Empleado] OFF
GO
SET IDENTITY_INSERT [dbo].[Producto] ON 
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (1, N'Arroz Costeño 1kg', CAST(4.50 AS Decimal(10, 2)), N'Alimentos', CAST(N'2025-12-31' AS Date), 1, N'P001', 50)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (2, N'Lentejas Selecta 500g', CAST(3.20 AS Decimal(10, 2)), N'Alimentos', CAST(N'2025-12-15' AS Date), 2, N'P002', 40)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (3, N'Harina Blanca Flor 1kg', CAST(4.80 AS Decimal(10, 2)), N'Alimentos', CAST(N'2026-01-10' AS Date), 3, N'P003', 35)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (4, N'Inka Kola 1.5L', CAST(5.50 AS Decimal(10, 2)), N'Bebidas', CAST(N'2025-10-01' AS Date), 4, N'P004', 68)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (5, N'Coca Cola 2L', CAST(6.00 AS Decimal(10, 2)), N'Bebidas', CAST(N'2025-09-25' AS Date), 5, N'P005', 70)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (6, N'Agua Cielo 2.5L', CAST(2.50 AS Decimal(10, 2)), N'Bebidas', CAST(N'2025-11-15' AS Date), 6, N'P006', 80)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (7, N'Leche Gloria Entera 400ml', CAST(3.50 AS Decimal(10, 2)), N'Lácteos', CAST(N'2025-08-20' AS Date), 7, N'P007', 55)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (8, N'Queso Fresco 250g', CAST(6.00 AS Decimal(10, 2)), N'Lácteos', CAST(N'2025-07-30' AS Date), 8, N'P008', 30)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (9, N'Yogurt Laive Fresa 1L', CAST(5.20 AS Decimal(10, 2)), N'Lácteos', CAST(N'2025-09-10' AS Date), 9, N'P009', 40)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (10, N'Pollo Entero 1.2kg', CAST(12.00 AS Decimal(10, 2)), N'Carnes', CAST(N'2025-06-25' AS Date), 10, N'P010', 25)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (11, N'Carne Molida 500g', CAST(10.50 AS Decimal(10, 2)), N'Carnes', CAST(N'2025-06-24' AS Date), 11, N'P011', 20)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (12, N'Salsa de Tomate 200g', CAST(2.30 AS Decimal(10, 2)), N'Abarrotes', CAST(N'2026-03-15' AS Date), 12, N'P012', 45)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (13, N'Sopas Maggi Gallina', CAST(1.50 AS Decimal(10, 2)), N'Abarrotes', CAST(N'2026-04-10' AS Date), 13, N'P013', 60)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (14, N'Detergente Ariel 1kg', CAST(7.80 AS Decimal(10, 2)), N'Limpieza', CAST(N'2027-01-01' AS Date), 14, N'P014', 50)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (15, N'Lejía Clorox 1L', CAST(4.20 AS Decimal(10, 2)), N'Limpieza', CAST(N'2026-12-01' AS Date), 15, N'P015', 55)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (16, N'Papel Higiénico Elite x4', CAST(6.50 AS Decimal(10, 2)), N'Higiene', CAST(N'2027-02-15' AS Date), 16, N'P016', 40)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (17, N'Shampoo Head & Shoulders 400ml', CAST(14.00 AS Decimal(10, 2)), N'Higiene', CAST(N'2026-11-30' AS Date), 17, N'P017', 35)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (18, N'Pan de molde Bimbo', CAST(5.00 AS Decimal(10, 2)), N'Panadería', CAST(N'2025-06-28' AS Date), 18, N'P018', 25)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (19, N'Croissant de mantequilla', CAST(2.80 AS Decimal(10, 2)), N'Panadería', CAST(N'2025-06-22' AS Date), 19, N'P019', 30)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (20, N'Pan francés x10', CAST(3.00 AS Decimal(10, 2)), N'Panadería', CAST(N'2025-06-22' AS Date), 20, N'P020', 50)
GO
INSERT [dbo].[Producto] ([id_producto], [descripcion], [precio], [categoria], [fechaVencimiento], [id_proveedor], [codigo], [stock]) VALUES (21, N'arroz', CAST(6.00 AS Decimal(10, 2)), N'Alimentos', CAST(N'2025-06-10' AS Date), 1, N'P021', 45)
GO
SET IDENTITY_INSERT [dbo].[Producto] OFF
GO
SET IDENTITY_INSERT [dbo].[Proveedor] ON 
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (1, N'Proveedor Uno', N'987654321', N'Calle Lima', N'Av. Perú', N'MZ 1', N'10101010101', N'proveedor1@mail.com', CAST(N'2024-01-01' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (2, N'Proveedor Dos', N'987654322', N'Calle Arequipa', N'Av. Brasil', N'MZ 2', N'10101010102', N'proveedor2@mail.com', CAST(N'2024-01-02' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (3, N'Proveedor Tres', N'987654323', N'Calle Cusco', N'Av. Argentina', N'MZ 3', N'10101010103', N'proveedor3@mail.com', CAST(N'2024-01-03' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (4, N'Proveedor Cuatro', N'987654324', N'Calle Piura', N'Av. Venezuela', N'MZ 4', N'10101010104', N'proveedor4@mail.com', CAST(N'2024-01-04' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (5, N'Proveedor Cinco', N'987654325', N'Calle Ica', N'Av. Bolivia', N'MZ 5', N'10101010105', N'proveedor5@mail.com', CAST(N'2024-01-05' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (6, N'Proveedor Seis', N'987654326', N'Calle Tacna', N'Av. Chile', N'MZ 6', N'10101010106', N'proveedor6@mail.com', CAST(N'2024-01-06' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (7, N'Proveedor Siete', N'987654327', N'Calle Puno', N'Av. Ecuador', N'MZ 7', N'10101010107', N'proveedor7@mail.com', CAST(N'2024-01-07' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (8, N'Proveedor Ocho', N'987654328', N'Calle Loreto', N'Av. Argentina', N'MZ 8', N'10101010108', N'proveedor8@mail.com', CAST(N'2024-01-08' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (9, N'Proveedor Nueve', N'987654329', N'Calle Huánuco', N'Av. México', N'MZ 9', N'10101010109', N'proveedor9@mail.com', CAST(N'2024-01-09' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (10, N'Proveedor Diez', N'987654330', N'Calle Ayacucho', N'Av. Canadá', N'MZ 10', N'10101010110', N'proveedor10@mail.com', CAST(N'2024-01-10' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (11, N'Proveedor Once', N'987654331', N'Calle Junín', N'Av. Venezuela', N'MZ 11', N'10101010111', N'proveedor11@mail.com', CAST(N'2024-01-11' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (12, N'Proveedor Doce', N'987654332', N'Calle Cajamarca', N'Av. Brasil', N'MZ 12', N'10101010112', N'proveedor12@mail.com', CAST(N'2024-01-12' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (13, N'Proveedor Trece', N'987654333', N'Calle Ancash', N'Av. Perú', N'MZ 13', N'10101010113', N'proveedor13@mail.com', CAST(N'2024-01-13' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (14, N'Proveedor Catorce', N'987654334', N'Calle Apurímac', N'Av. Chile', N'MZ 14', N'10101010114', N'proveedor14@mail.com', CAST(N'2024-01-14' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (15, N'Proveedor Quince', N'987654335', N'Calle Moquegua', N'Av. Argentina', N'MZ 15', N'10101010115', N'proveedor15@mail.com', CAST(N'2024-01-15' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (16, N'Proveedor Dieciséis', N'987654336', N'Calle Amazonas', N'Av. Brasil', N'MZ 16', N'10101010116', N'proveedor16@mail.com', CAST(N'2024-01-16' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (17, N'Proveedor Diecisiete', N'987654337', N'Calle Madre de Dios', N'Av. México', N'MZ 17', N'10101010117', N'proveedor17@mail.com', CAST(N'2024-01-17' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (18, N'Proveedor Dieciocho', N'987654338', N'Calle Ucayali', N'Av. Bolivia', N'MZ 18', N'10101010118', N'proveedor18@mail.com', CAST(N'2024-01-18' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (19, N'Proveedor Diecinueve', N'987654339', N'Calle Tumbes', N'Av. Venezuela', N'MZ 19', N'10101010119', N'proveedor19@mail.com', CAST(N'2024-01-19' AS Date))
GO
INSERT [dbo].[Proveedor] ([id_proveedor], [nombre], [telefono], [direccion_calle], [direccion_av], [direccion_mz], [RUC], [email], [fechaRegistro]) VALUES (20, N'Proveedor Veinte', N'987654340', N'Calle San Martín', N'Av. Ecuador', N'MZ 20', N'10101010120', N'proveedor20@mail.com', CAST(N'2024-01-20' AS Date))
GO
SET IDENTITY_INSERT [dbo].[Proveedor] OFF
GO
SET IDENTITY_INSERT [dbo].[Venta] ON 
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (1, CAST(N'2025-06-01' AS Date), N'Efectivo', 1, 1)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (2, CAST(N'2025-06-02' AS Date), N'Tarjeta', 2, 2)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (3, CAST(N'2025-06-03' AS Date), N'Yape', 3, 3)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (4, CAST(N'2025-06-04' AS Date), N'Efectivo', 4, 4)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (5, CAST(N'2025-06-05' AS Date), N'Tarjeta', 5, 5)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (6, CAST(N'2025-06-06' AS Date), N'Efectivo', 6, 6)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (7, CAST(N'2025-06-07' AS Date), N'Tarjeta', 7, 7)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (8, CAST(N'2025-06-08' AS Date), N'Yape', 8, 8)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (9, CAST(N'2025-06-09' AS Date), N'Efectivo', 9, 9)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (10, CAST(N'2025-06-10' AS Date), N'Tarjeta', 10, 10)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (11, CAST(N'2025-06-11' AS Date), N'Efectivo', 11, 11)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (12, CAST(N'2025-06-12' AS Date), N'Yape', 12, 12)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (13, CAST(N'2025-06-13' AS Date), N'Tarjeta', 13, 13)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (14, CAST(N'2025-06-14' AS Date), N'Efectivo', 14, 14)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (15, CAST(N'2025-06-15' AS Date), N'Tarjeta', 15, 15)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (16, CAST(N'2025-06-16' AS Date), N'Yape', 16, 16)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (17, CAST(N'2025-06-17' AS Date), N'Efectivo', 17, 17)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (18, CAST(N'2025-06-18' AS Date), N'Tarjeta', 18, 18)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (19, CAST(N'2025-06-19' AS Date), N'Efectivo', 19, 19)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (20, CAST(N'2025-06-20' AS Date), N'Yape', 20, 20)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (21, CAST(N'2025-06-23' AS Date), N'METODO DE PAGO', 1, 3)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (22, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 10)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (23, CAST(N'2025-06-29' AS Date), N'YAPE', 1, 1)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (24, CAST(N'2025-06-29' AS Date), N'EFECTIVO', 1, 6)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (25, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 5)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (26, CAST(N'2025-06-29' AS Date), N'YAPE', 1, 6)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (27, CAST(N'2025-06-29' AS Date), N'EFECTIVO', 1, 2)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (28, CAST(N'2025-06-29' AS Date), N'EFECTIVO', 1, 2)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (29, CAST(N'2025-06-29' AS Date), N'EFECTIVO', 1, 5)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (30, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 2)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (31, CAST(N'2025-06-29' AS Date), N'EFECTIVO', 1, 6)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (32, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 6)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (33, CAST(N'2025-06-29' AS Date), N'YAPE', 1, 8)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (34, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 9)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (35, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 5)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (36, CAST(N'2025-06-29' AS Date), N'YAPE', 1, 4)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (37, CAST(N'2025-06-29' AS Date), N'EFECTIVO', 1, 5)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (38, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 5)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (39, CAST(N'2025-06-29' AS Date), N'METODO DE PAGO', 1, 5)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (40, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 7)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (41, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 8)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (42, CAST(N'2025-06-29' AS Date), N'EFECTIVO', 1, 7)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (43, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 7)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (44, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 3)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (45, CAST(N'2025-06-29' AS Date), N'YAPE', 1, 5)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (46, CAST(N'2025-06-29' AS Date), N'YAPE', 1, 4)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (47, CAST(N'2025-06-29' AS Date), N'TARJETA', 1, 1)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (48, CAST(N'2025-06-29' AS Date), N'EFECTIVO', 1, 1)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (49, CAST(N'2025-06-29' AS Date), N'YAPE', 1, 7)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (50, CAST(N'2025-06-30' AS Date), N'EFECTIVO', 1, 4)
GO
INSERT [dbo].[Venta] ([id_venta], [fechaVenta], [metodoPago], [id_empleado], [id_cliente]) VALUES (1047, CAST(N'2025-06-30' AS Date), N'TARJETA', 1, 5)
GO
SET IDENTITY_INSERT [dbo].[Venta] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_codigo_producto]    Script Date: 30/06/2025 21:13:45 ******/
ALTER TABLE [dbo].[Producto] ADD  CONSTRAINT [UQ_codigo_producto] UNIQUE NONCLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Producto] ADD  DEFAULT ('001') FOR [codigo]
GO
ALTER TABLE [dbo].[Producto] ADD  DEFAULT ((0)) FOR [stock]
GO
ALTER TABLE [dbo].[DetalleVenta]  WITH CHECK ADD FOREIGN KEY([id_producto])
REFERENCES [dbo].[Producto] ([id_producto])
GO
ALTER TABLE [dbo].[DetalleVenta]  WITH CHECK ADD FOREIGN KEY([id_venta])
REFERENCES [dbo].[Venta] ([id_venta])
GO
ALTER TABLE [dbo].[Producto]  WITH CHECK ADD  CONSTRAINT [FK_Producto_Proveedor] FOREIGN KEY([id_proveedor])
REFERENCES [dbo].[Proveedor] ([id_proveedor])
GO
ALTER TABLE [dbo].[Producto] CHECK CONSTRAINT [FK_Producto_Proveedor]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD FOREIGN KEY([id_cliente])
REFERENCES [dbo].[Cliente] ([id_cliente])
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD FOREIGN KEY([id_empleado])
REFERENCES [dbo].[Empleado] ([id_empleado])
GO
