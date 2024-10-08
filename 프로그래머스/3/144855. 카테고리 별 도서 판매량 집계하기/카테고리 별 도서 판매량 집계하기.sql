SELECT CATEGORY,SUM(SALES) TOTAL_SALES
FROM BOOK LEFT JOIN BOOK_SALES 
ON BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
WHERE MONTH(SALES_DATE) = 1 AND YEAR(SALES_DATE) = 2022
GROUP BY CATEGORY
ORDER BY CATEGORY;