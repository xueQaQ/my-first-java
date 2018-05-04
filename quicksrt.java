	public static void quicksrt(int[] v,int left,int right) {
		int key = v[left];
		int low = left;
		int hight = right;
		if(low < hight) {
			while(low < hight && v[hight] > key) {
				hight--;
			}
			v[low] = v[hight];
			while(low < hight && v[low] < key) {
				low--;
			}
			v[hight] = v[low];
		}
		v[low] = key;
		quicksrt(v, left, low-1);
		quicksrt(v, low+1, right);
	}