package cinema;

public class Order {
    private Movie movie;
    private int ticketAmount;
    private Food food;
    private Cinema cinema;
    private Theater theater;

    public Order(Movie movie, int ticketAmount, Food food, Cinema cinema, Theater theater) {
        this.movie = movie;
        this.ticketAmount = ticketAmount;
        this.food = food;
        this.cinema = cinema;
        this.theater = theater;
    }

    public double getTotalPrice() {
        double tiketPrice = theater.getPrice();
        double foodPrice = (food != null) ? food.getPrice() : 0;
        double totalPrice = (tiketPrice * ticketAmount) + foodPrice;
        return totalPrice;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public Food getFood() {
        return food;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Theater getTheater() {
        return theater;
    }
}
