package befaster.solutions;

import java.util.ArrayList;
import java.util.Collections;
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
        checkCombination(itemCounts);
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
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 20;
                    break;
                case 'H':
                    itemCount = itemCounts.get(item);
                    if (itemCount >= 10) {
                        totalPrice += (itemCount / 10) * 80;
                        itemCount = itemCount % 10;
                    }
                    if (itemCount >= 5) {
                        totalPrice += (itemCount / 5) * 45;
                        itemCount = itemCount % 5;
                    }
                    if (itemCount <= 4) {
                        totalPrice += itemCount * 10;
                    }
                    break;
                case 'I':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 35;
                    break;
                case 'J':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 60;
                    break;
                case 'K':
                    itemCount = itemCounts.get(item);
                    totalPrice += ((itemCount % 2) * 80) + ((itemCount / 2) * 150);
                    break;
                case 'L':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 90;
                    break;
                case 'M':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 15;
                    break;
                case 'N':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 40;
                    break;
                case 'O':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 10;
                    break;
                case 'P':
                    itemCount = itemCounts.get(item);
                    totalPrice += ((itemCount % 5) * 50) + ((itemCount / 5) * 200);
                    break;
                case 'Q':
                    itemCount = itemCounts.get(item);
                    totalPrice += ((itemCount % 3) * 30) + ((itemCount / 3) * 80);
                    break;
                case 'R':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 50;
                    break;
                case 'S':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 30;
                    break;
                case 'T':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 20;
                    break;
                case 'U':
                    itemCount = itemCounts.get(item);
                    if (itemCount <= 3) {
                        totalPrice += itemCount * 40;
                    } else {
                        int rem = itemCount % 4;
                        int div = itemCount / 4;
                        totalPrice += ((div * 3) + rem) * 40;
                    }
                    break;
                case 'V':
                    itemCount = itemCounts.get(item);
                    if (itemCount >= 3) {
                        totalPrice += (itemCount / 3) * 130;
                        itemCount = itemCount % 3;
                    }
                    if (itemCount >= 2) {
                        totalPrice += (itemCount / 2) * 90;
                        itemCount = itemCount % 2;
                    }
                    if (itemCount == 1) {
                        totalPrice += itemCount * 50;
                    }
                    break;
                case 'W':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 20;
                    break;
                case 'X':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 90;
                    break;
                case 'Y':
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 10;
                    break;
                case 'Z':
                    if(characters.contains('X' )){

                    }
                    itemCount = itemCounts.get(item);
                    totalPrice += itemCount * 50;
                    break;
            }
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
        Integer getNCount = itemCounts.get('N');
        Integer getRCount = itemCounts.get('R');

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

        if (!Objects.isNull(getNCount)) {
            Integer bCount = itemCounts.get('M');
            if (!Objects.isNull(bCount)) {
                int eOffer = getNCount / 3;
                int bOffer = bCount - eOffer;
                if (eOffer > bCount) {
                    bOffer = 0;
                }
                itemCounts.replace('M', bCount, bOffer);
            }
        }

        if (!Objects.isNull(getRCount)) {
            Integer bCount = itemCounts.get('Q');
            if (!Objects.isNull(bCount)) {
                int eOffer = getRCount / 3;
                int bOffer = bCount - eOffer;
                if (eOffer > bCount) {
                    bOffer = 0;
                }
                itemCounts.replace('Q', bCount, bOffer);
            }
        }
    }

    private static int checkCombination(Map<Character, Integer> itemCounts){

        char c[] = new char[]{'S','T','X','Y','Z'};
        int offerCount = 0;
        List<Integer> integerList = new ArrayList<>();

        for (int i=0; i<=4 ;i++){
            if (Objects.isNull(itemCounts.get(c[i]))){
                offerCount++;
            }else{
                integerList.add(itemCounts.get(c[i]));
            }
            if (offerCount == 3){
                return 0;
            }
        }
        checkOfferCombination(integerList);

        return 1;
    }

    private static void checkOfferCombination(List<Integer> integerList) {
        Collections.sort(integerList);
        int totalOfferCount =0;
        for (int i =0; i<integerList.size(); i++ ){
            integerList.add(i,integerList.get(0)-integerList.get(integerList.size()-i));
            integerList.add(i,integerList.get(1)-integerList.get(integerList.size()-i));
            totalOfferCount = integerList.get(integerList.size()-i);
            Collections.sort(integerList);

        }
        System.out.println(totalOfferCount);
    }
}
