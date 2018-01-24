package search;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * 分块查找
 *
 * @author BrianCai
 * @version 2018年1月24日
 * @see IndexBlock
 * @since
 */
public class IndexBlockSearch_1_1 {

    int blockSize = 3;

    class IndexTable {

        /**
         * 块内最大值索引
         */
        private int index;

        /**
         * 块内的最大值
         */
        private int maxkey;

        public IndexTable(int index, int maxkey) {
            this.index = index;
            this.maxkey = maxkey;
        }
    }

    /**
     * Description: 分块查找
     * 
     * @param array
     * @return boolean
     * @see
     */
    public boolean blockSearch(int[] array, int searchVal) {

        // 查看数组
        printArray(array);

        List<IndexTable> indexList = new ArrayList<>();

        if (array.length <= 0) {
            return false;
        }

        getAllIndexMaxKey(array, indexList);

        for (IndexTable indexTable : indexList) {
            if (searchVal > indexTable.maxkey) {
                continue;
            }
            else {
                int index = indexTable.index;
                while (blockSize > 0) {
                    if (index >= 0) {
                        if (array[index] == searchVal) {
                            return true;
                        }
                        index-- ;
                        blockSize-- ;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Description:对数组进行分块，构建分块索引表
     * 
     * @return List<Index>
     * @see
     */
    public void getAllIndexMaxKey(int[] array, List<IndexTable> indexList) {

        // 每块包含n个元素

        bulidBlockIndexMaxKey(array, blockSize, indexList);
        printIndexTable(indexList);
    }

    /**
     * Description: 构建索引表
     * 
     * @param array
     * @param blockSize
     * @param indexList
     * @return List<IndexTable>
     * @see
     */
    private List<IndexTable> bulidBlockIndexMaxKey(int[] array, int blockSize,
                                                   List<IndexTable> indexList) {

        int length = array.length;

        for (int i = 0; i < length; i += blockSize) {
            int max = 0;
            int index = 0;
            int start = i;
            int end = (start + blockSize) > length ? length : start + blockSize;
            for (; start < end; start++ ) {
                if (max < array[start]) {
                    max = array[start];
                    index = start;
                }

            }
            IndexTable indexTable = new IndexTable(index, max);
            indexList.add(indexTable);
        }

        return null;
    }

    /**
     * Description:查看数组
     * 
     * @param array
     *            void
     * @see
     */
    private void printArray(int[] array) {
        System.out.println("****************数组元素如下************************");
        if (array.length <= 0) {
            System.out.println("数组为空");
            return;
        }
        for (int i = 0; i < array.length; i++ ) {
            System.out.print(array[i] + "   ");
        }
        System.out.println("");
    }

    /**
     * Description:查看索引表
     * 
     * @param indexList
     *            void
     * @see
     */
    private void printIndexTable(List<IndexTable> indexList) {
        System.out.println("****************索引表元素如下************************");
        for (IndexTable indexTable : indexList) {
            System.out.print(indexTable.index + "-" + indexTable.maxkey + " | ");
        }
        System.out.println("");
    }

    @Test
    public void test() {
        // int[] array = new int[] {1, 6, 3, 7, 9, 8, 12, 15};
        int[] array = new int[] {};
        int a = 11;
        System.out.println("the result....." + blockSearch(array, a));
    }
}
