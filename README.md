# Storm Reply - Daily Coding Problem

This is a playground for solving programming problems in Kotlin. For now the source for the problems to solve is the website [Daily Coding Problem](https://www.dailycodingproblem.com).

> [Daily Coding Problem](https://www.dailycodingproblem.com) is an interview preparation service. We collect the most popular coding interview questions and send one hard interview programming problem to your inbox every day. We write up easy-to-understand solutions to them and send them the day after (so you can think about the problem during the day).

## How To Solve a Hard Programming Question

So let's go over the thought process for solving tricky coding questions. The question we'll work through is the following: **return a new sorted merged list from K sorted lists, each with size N**. Before we move on any further, you should take some time to think about the solution!

* First, go through an example. This makes sure you understand the problem, and lets you gain some intuition for the problem. For example, if we had `[[10, 15, 30], [12, 15, 20], [17, 20, 32]]`, the result should be `[10, 12, 15, 15, 17, 20, 20, 30, 32]`.

* Next, give any solution you can think of (even if it's brute force). It seems obvious that if we just flattened the lists and sorted it, we would get the answer we want. The time complexity for that would be `O(KN log KN)`, since we have `K * N` total elements.

* The third step is to think of pseudocode -- a high-level solution for the problem. This is where we explore different solutions. The things we are looking for are better space/time complexities but also the difficulty of the implementation. You should be able to finish the solution in 30 minutes. Here, we can see that we only need to look at `K` elements in each of the lists to find the smallest element initially. Heaps are great for finding the smallest element. Let's say the smallest element is `E`. Once we get `E`, we know we're interested in only the next element of the list that held `E`. Then we'd extract out the second smallest element and etc. The time complexity for this would be `O(KN log K)`, since we remove and append to the heap `K * N` times.

* Initialize the heap. In Python this this is just a list. We need `K` tuples. One for the index for which list among the list of lists the element lives; one for the element index which is where the element lives; and the value of the element. Since we want the key of the heap to be based on the value of the element, we should put that first in the tuple.

* While the heap is not empty we need to:
   * Extract the minimum element from the heap: (value, list index, element index)
   * If the element index is not at the last index, add the next tuple in the list index.

* Write the actual code. Ideally, at this point, it should be clear how the code should look like. Here's one example:
```
def merge(lists):
    merged_list = []

    heap = [(lst[0], i, 0) for i, lst in enumerate(lists) if lst]
    heapq.heapify(heap)

    while heap:
        val, list_ind, element_ind = heapq.heappop(heap)

        merged_list.append(val)

        if element_ind + 1 < len(lists[list_ind]):
            next_tuple = (lists[list_ind][element_ind + 1],
                          list_ind,
                          element_ind + 1)
            heapq.heappush(heap, next_tuple)
    return merged_list
```
* Think of test cases. I like to think of happy cases and edge cases. Our original example would be a happy case. Edge cases might be.

   * `lists` is `[]`.
   * `lists` only contains empty lists: `[[], [], []]`.
   * `lists` contains empty lists and non-empty lists: `[[], [1], [1,2]]`.
   * `lists` contains one list with one element: `[[1]]`.
   * `lists` contains lists of varying size: `[[1], [1, 3, 5], [1, 10, 20, 30, 40]]`.

Finally, you should ask yourself some follow-up questions. One common question is: what other solutions are there? There's actually another relatively simple solution that would use a divide-and-conquer strategy. We could recursively merge each half of the lists and then combine the two lists. This would have the same asymptotic complexities but would require more "real" memory and time.
