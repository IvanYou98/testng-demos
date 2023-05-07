import org.testng.annotations.Test;

public class TestPriority {
    @Test(priority = 1)
    public void loginToBooking() {
        System.out.println("Log in to booking.com");
    }

    @Test(priority = 2)
    public void selectFlight() {
        System.out.println("Select departure and destination");
        System.out.println("Select Date");
    }

    @Test(priority = 3)
    public void enterInformation() {
        System.out.println("Enter name");
        System.out.println("Enter passport number");
        System.out.println("Enter credit card number");
    }

    @Test(priority = 4)
    public void confirm() {
        System.out.println("Confirm the information");
        System.out.println("Checkout");
        System.out.println("===============");
    }
}
