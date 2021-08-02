import java.util.*;

/**
 * @author tfliu
 * @title: Test
 * @projectName oauth2-study
 * @description: TODO
 * @date 7/27/218:28 PM
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 4, 5};
        Integer maxNum = getMaxNumber(arr);
        if (null == maxNum){
            System.out.println("无最大数");
            return;
        }
        System.out.println("最大数为：" + maxNum);
    }

    /**
     * 获取最大数
     * @param arr
     * @return
     */
    private static Integer getMaxNumber(int[] arr){
        if (null==arr || arr.length==0){
            return null;
        }

        int compareNumber = arr.length/2;
        // 获取出现次数最多的数
        LinkedList<Integer> maxAmountNumberList = getMaxAmountNumber(arr);
        if (maxAmountNumberList.size()<=compareNumber){
            return null;
        }

        return maxAmountNumberList.get(0);
    }

    /**
     * 获取出现次数最多的数
     * @param arr
     * @return
     */
    private static LinkedList<Integer> getMaxAmountNumber(int[] arr) {
//        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        // toMap
        Map<Integer, LinkedList<Integer>> arrToMap = arrToMap(arr);
        LinkedList<Integer> largestList = null;
        // 获取list最大数
        for (LinkedList<Integer> temList : arrToMap.values()) {
            if (null == largestList){
                largestList = temList;
            }
            if(temList.size()>largestList.size()){
                largestList = temList;
            }
        }

        return largestList;
    }

    /**
     * arr转map key: 具体数字； value: 相同元素list
     * @param arr
     * @return
     */
    private static Map<Integer, LinkedList<Integer>> arrToMap(int[] arr) {
        Map<Integer, LinkedList<Integer>> arrToMap = new HashMap();
        Arrays.stream(arr).forEach(e -> {
            if (arrToMap.get(e)==null){
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(e);
                arrToMap.put(e,linkedList);
            }else {
                arrToMap.get(e).add(e);
            }
        });

        return arrToMap;
    }
}
