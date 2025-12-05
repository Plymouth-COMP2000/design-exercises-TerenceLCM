package com.example.restaurantapp.data

import com.example.restaurantapp.R
import com.example.restaurantapp.model.MenuItem
import com.example.restaurantapp.model.Reservation
import com.example.restaurantapp.model.ReservationStatus

object DummyDataProvider {

    fun getSampleMenuItems(): List<MenuItem> {
        return listOf(
            MenuItem(
                id = "menu_001",
                name = "Grilled Salmon",
                price = 24.99,
                description = "Fresh Atlantic salmon grilled to perfection, served with seasonal vegetables and lemon butter sauce.",
                category = "Main Course",
                imageResId = R.drawable.grilled_salmon
            ),
            MenuItem(
                id = "menu_002",
                name = "Beef Tenderloin",
                price = 32.99,
                description = "Premium cut of beef, cooked to your preference, accompanied by roasted potatoes and red wine reduction.",
                category = "Main Course",
                imageResId = R.drawable.beef_tenderloin
            ),
            MenuItem(
                id = "menu_003",
                name = "Caesar Salad",
                price = 12.99,
                description = "Crisp romaine lettuce with homemade Caesar dressing, parmesan cheese, and croutons.",
                category = "Salad",
                imageResId = R.drawable.caesar_salad
            ),
            MenuItem(
                id = "menu_004",
                name = "Margherita Pizza",
                price = 16.99,
                description = "Classic Italian pizza with fresh mozzarella, tomato sauce, and basil on our house-made dough.",
                category = "Pizza",
                imageResId = R.drawable.margherita_pizza
            ),
            MenuItem(
                id = "menu_005",
                name = "Chocolate Lava Cake",
                price = 8.99,
                description = "Warm chocolate cake with a molten center, served with vanilla ice cream and fresh berries.",
                category = "Dessert",
                imageResId = R.drawable.lava_chocolate_cake
            ),
            MenuItem(
                id = "menu_006",
                name = "Lobster Risotto",
                price = 28.99,
                description = "Creamy arborio rice with fresh lobster, white wine, and parmesan cheese.",
                category = "Main Course",
                imageResId = R.drawable.lobster_risotto
            ),
            MenuItem(
                id = "menu_007",
                name = "Caprese Salad",
                price = 11.99,
                description = "Fresh mozzarella, ripe tomatoes, and basil drizzled with balsamic reduction.",
                category = "Salad",
                imageResId = R.drawable.caprese_salad
            ),
            MenuItem(
                id = "menu_008",
                name = "Tiramisu",
                price = 9.99,
                description = "Traditional Italian dessert with layers of coffee-soaked ladyfingers and mascarpone cream.",
                category = "Dessert",
                imageResId = R.drawable.tiramisu
            )
        )
    }

    fun getSampleReservations(): List<Reservation> {
        return listOf(
            Reservation(
                id = "RES-001",
                customerName = "John Smith",
                partySize = 2,
                date = "December 25, 2024",
                time = "7:00 PM",
                status = ReservationStatus.PENDING,
                email = "john.smith@email.com",
                phone = "(555) 123-4567"
            ),
            Reservation(
                id = "RES-002",
                customerName = "Emily Johnson",
                partySize = 4,
                date = "December 25, 2024",
                time = "8:30 PM",
                status = ReservationStatus.CONFIRMED,
                email = "emily.j@email.com",
                phone = "(555) 234-5678"
            ),
            Reservation(
                id = "RES-003",
                customerName = "Michael Brown",
                partySize = 1,
                date = "December 26, 2024",
                time = "6:00 PM",
                status = ReservationStatus.PENDING,
                email = "m.brown@email.com",
                phone = "(555) 345-6789"
            ),
            Reservation(
                id = "RES-004",
                customerName = "Sarah Davis",
                partySize = 6,
                date = "December 26, 2024",
                time = "7:30 PM",
                status = ReservationStatus.CONFIRMED,
                email = "sarah.d@email.com",
                phone = "(555) 456-7890"
            ),
            Reservation(
                id = "RES-005",
                customerName = "David Wilson",
                partySize = 2,
                date = "December 27, 2024",
                time = "8:00 PM",
                status = ReservationStatus.CANCELLED,
                email = "d.wilson@email.com",
                phone = "(555) 567-8901"
            ),
            Reservation(
                id = "RES-006",
                customerName = "Lisa Anderson",
                partySize = 3,
                date = "December 27, 2024",
                time = "6:30 PM",
                status = ReservationStatus.PENDING,
                email = "lisa.a@email.com",
                phone = "(555) 678-9012"
            )
        )
    }
}

