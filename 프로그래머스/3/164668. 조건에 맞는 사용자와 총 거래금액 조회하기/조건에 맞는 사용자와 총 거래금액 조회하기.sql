-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, TOTAL_SALES
FROM USED_GOODS_USER join (SELECT WRITER_ID, SUM(PRICE) TOTAL_SALES
FROM USED_GOODS_BOARD
WHERE STATUS = 'DONE'
GROUP BY WRITER_ID) W
WHERE USER_ID = W.WRITER_ID AND W.TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES;


;


