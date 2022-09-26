from typing import List
class Solution:
    def noNeighbouringFlower(self, flowerbed, i):
        print(flowerbed)
        if len(flowerbed) == 1:
            return True
        if i == 0:
            return (flowerbed[1] == 0)
        if i == len(flowerbed) - 1:
            return (flowerbed[i - 1] == 0)
        return flowerbed[i - 1] == 0 and flowerbed[i + 1] == 0
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        noOfFlowers = 0
        for i in range(0, len(flowerbed)):
            if(flowerbed[i] == 0 and self.noNeighbouringFlower(flowerbed, i)):
                # can place a flower here
                flowerbed[i] = 1
                noOfFlowers+=1
        if noOfFlowers >= n:
            return True
        return False


s = Solution()
print(s.canPlaceFlowers([0, 0, 0], 2))