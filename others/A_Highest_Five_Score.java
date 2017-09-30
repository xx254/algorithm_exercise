/*
可以改进的地方：
pq每加入一个元素的时候判断是否在top 5，这样可以节省offer再poll的时间，这也要求pq是递增的而非递减的。
多次用到的变量保存下来，避免总用h.get()等操作，
此外，结果为Double所以做除法时size要保证是Double的（或者5.0）
*/

class Record {
      public int id, score;
      public Record(int id, int score){
          this.id = id;
          this.score = score;
    }
  }


  public Map<Integer, Double> highFive(Record[] results){
      HashMap<Integer, Double> res = new HashMap<>();
      HashMap<Integer, PriorityQueue<Integer>> h = new HashMap<>();
      PriorityQueue<Integer> pq = null;
      Double average = 0.0;
      int sum = 0;

      for(Record rec : results){
          if(!h.containsKey(rec.id)){
              pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
                  @Override
                  public int compare(Integer o1, Integer o2){
                      return o2 - o1;
                  }
              });
          } else {
              pq = h.get(rec.id);
          }
          pq.offer(rec.score);
          if(pq.size() > 5){
              pq.poll();
          }
          h.put(rec.id, pq);
      }
      for(Map.Entry<Integer, PriorityQueue<Integer>> entry : h.entrySet()){
          for(int i=0; i<5; i++){
              sum += entry.getValue().poll();
          }
          average = sum / 5.0;
          res.put(entry.getKey(), average);
      }
      return res;
  }
