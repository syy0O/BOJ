-- 코드를 작성해주세요
SELECT I.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO I 
WHERE I.ITEM_ID NOT IN (
    SELECT PARENT_ITEM_ID
    FROM ITEM_TREE
    WHERE PARENT_ITEM_ID IS NOT NULL
)
ORDER BY I.ITEM_ID DESC