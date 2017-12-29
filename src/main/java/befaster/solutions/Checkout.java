package befaster.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Checkout {

    private static final String NAME = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    /**
     * Method is responsible to calculate item price
     *
     * @param skus : order list
     * @return total price
     */
    public static Integer checkout(String skus) {

        Map<Character, Integer> itemCounts = new HashMap<>();
        for (char item : skus.toCharArray()) {
            if (NAME.contains(String.valueOf(item))) {
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
        Integer itemCount;
        calculateOffer(itemCounts);
        Set<Character> characters = itemCounts.keySet();
        int totalPrice = 0;

        for (char item : characters) {
            switch (item) {
                case 'A':
                    itemCount = itemCounts.get(item);
                    if (itemCount >= 5) {
                        totalPrice += (itemCount / 5) * 200;
                        itemCount = itemCount % 5;
                    }
                    if (itemCount >= 3) {
                        totalPrice += (itemCount / 3) * 130;
                        itemCount = itemCount % 3;
                    }
                    if (itemCount <= 2) {
                        totalPrice += itemCount * 50;
                    }
                    break;
                case 'B':
                    itemCount = itemCounts.get(item);
                    totalPrice += ((itemCount % 2) * 30) + ((itemCount / 2) * 45);
                    break;
                case 'C':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 20;
                    break;
                case 'D':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 15;
                    break;
                case 'E':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 40;
                    break;
                case 'F':
                    itemCount = itemCounts.get(item);
                    if (itemCount <= 2) {
                        totalPrice += itemCount * 10;
                    } else {
                        int rem = itemCount % 3;
                        int div = itemCount / 3;
                        totalPrice += ((div * 2) + rem) * 10;
                    }
                    break;
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':

            }
           /* if (item == 'A') {
                Integer itemCount = itemCounts.get(item);
                if (itemCount >= 5) {
                    totalPrice += (itemCount / 5) * 200;
                    itemCount = itemCount % 5;
                }
                if (itemCount >= 3) {
                    totalPrice += (itemCount / 3) * 130;
                    itemCount = itemCount % 3;
                }
                if (itemCount <= 2) {
                    totalPrice += itemCount * 50;
                }
            } else if (item == 'B') {
                Integer itemCount = itemCounts.get(item);
                totalPrice += ((itemCount % 2) * 30) + ((itemCount / 2) * 45);
            } else if (item == 'C') {
                Integer itemCount = itemCounts.get(item);
                totalPrice += itemCount * 20;
            } else if (item == 'D') {
                Integer itemCount = itemCounts.get(item);
                totalPrice += itemCount * 15;
            } else if (item == 'E') {
                Integer itemCount = itemCounts.get(item);

                totalPrice += itemCount * 40;
            } else if (item == 'F') {
                Integer itemCount = itemCounts.get(item);
                if (itemCount <= 2) {
                    totalPrice += itemCount * 10;
                } else {
                    int rem = itemCount % 3;
                    int div = itemCount / 3;
                    totalPrice += ((div * 2) + rem) * 10;
                }
            }*/
        }
        return totalPrice;
    }

    /**
     * Update item counts cache as per E offer.
     *
     * @param itemCounts : item count cache.
     */
    private static void calculateOffer(Map<Character, Integer> itemCounts) {
        Integer getECount = itemCounts.get('E');

        if (!Objects.isNull(getECount)) {
            Integer bCount = itemCounts.get('B');
            if (!Objects.isNull(bCount)) {
                int eOffer = getECount / 2;
                int bOffer = bCount - eOffer;
                if (eOffer > bCount) {
                    bOffer = 0;
                }
                itemCounts.replace('B', bCount, bOffer);
            }
        }
    }
}
