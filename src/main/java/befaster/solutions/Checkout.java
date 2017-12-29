package befaster.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Checkout {

    /**
     * Method is responsible to calculate item price
     *
     * @param skus : order list
     * @return total price
     */
    public static Integer checkout(String skus) {

        Map<Character, Integer> itemCounts = new HashMap<>();
        for (char item : skus.toCharArray()) {
            if (item == 'A' || item == 'B' || item == 'C' || item == 'D') {
                Integer frequency = itemCounts.get(item);
                itemCounts.put(item, (Objects.isNull(frequency) ? 1 : frequency + 1));
            } else
                return -1;
        }

        return priceCalculation(itemCounts);
    }

    /**
     * Sub Method to calculate total price as per listed offer.
     *
     * @param itemCounts : number of item.
     * @return total price.
     */
    private static Integer priceCalculation(Map<Character, Integer> itemCounts) {

        Set<Character> characters = itemCounts.keySet();
        int totalPrice = 0;

        for (char item : characters) {
            if (item == 'A') {
                Integer itemCount = itemCounts.get(item);
                totalPrice += ((itemCount % 3) * 50) + ((itemCount / 3) * 130);
            } else if (item == 'B') {
                Integer itemCount = itemCounts.get(item);
                totalPrice += ((itemCount % 2) * 30) + ((itemCount / 2) * 45);
            } else if (item == 'C') {
                Integer itemCount = itemCounts.get(item);
                totalPrice += itemCount * 20;
            } else if (item == 'D') {
                Integer itemCount = itemCounts.get(item);
                totalPrice += itemCount * 15;
            }
        }
        return totalPrice;
    }
}
