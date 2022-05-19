

public class test {
    public static void main(String[] args) {
        OAdvisoryServiceImpl advisoryService = new OAdvisoryServiceImpl();
        OAdvisory advisory = new OAdvisory(1L, 1L, 2L, "hello");
        advisoryService.save(advisory);
    }
}
