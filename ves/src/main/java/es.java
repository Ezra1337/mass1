public class es {
    public static void main(String[] args) {
        final var weight = 50;
        System.out.println("weight = " + weight);
        var weight2 = 70;
        System.out.println("weight2 = " + weight2);
        final var weightRaznica = weight - weight2;
        System.out.println("weightRaznica = " + weightRaznica);
        final var weightSumma = weight + weight2;
        System.out.println("weightSumma = " + weightSumma);
        final var sredniiweight = (weight + weight2) / 2;
        System.out.println("sredniiweight = " + sredniiweight);
        final var weightYmnozhenie = weight * weight2;
        System.out.println("weightYmnozhenie = " + weightYmnozhenie);
    }
}