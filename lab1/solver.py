from maze import MAZE

def find_exit(maze, x, y, path=None):
    if path is None:
        path = []

    # Out of bounds or wall
    if x < 0 or y < 0 or x >= len(maze) or y >= len(maze[0]) or maze[x][y] == "X":
        return []
    
    # Found exit
    if maze[x][y] == "E":
        return[path + [(x, y)]]

    # Already visited
    if (x, y) in path:
        return []
    solutions = []
    # Explore neighbors (down, right, up, left)
    for dx, dy in [(1,0), (0,1), (-1,0), (0,-1)]:
        new_path = find_exit(maze, x+dx, y+dy, path + [(x, y)])
        solutions.extend(new_path)

    return solutions

if __name__ == "__main__":
    solution = find_exit(MAZE, 0, 0)
    print("Solution:")
    for sol in solution:
        print(sol)
