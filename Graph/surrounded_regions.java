
class Solution{
	
	private void paint(char[][]board,int i, int j){
	if(i<0  || i>=board.length || j<0 || j>=board[0].length || board[i][j] == 'T' || board[i][j]=='X' )return;
	board[i][j] = 'T';
	paint(board,i+1,j);
	paint(board,i-1,j);
	paint(board,i,j-1);
	paint(board,i,j+1);
	
}
	
public void solve(char[][] board){
		int n = board.length;
		int m = board[0].length;
		for(int i = 0;  i<n; i++){
	for(int j = 0; j<m; j++){
if(i == 0 || i == n-1 || j == 0 || j==m-1){
	if(board[i][j] == 'O'){
paint(board,i,j);
}
}

}
}
for(int i = 1; i<n-1; i++){
	for(int j = 1; j<m-1; j++){
		if(board[i][j] == 'O'){
			board[i][j] ='X';
}
}
}
for(int i = 0; i<n; i++){
	for(int j = 0; j<m; j++){
	if(board[i][j] == 'T')board[i][j] = 'O';
}
}
}

}
