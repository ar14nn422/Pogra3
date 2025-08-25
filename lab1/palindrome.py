def reverse_string(s: str) -> str:
    """Return the reversed string using recursion."""
    if len(s) == 0:#Cadena vacia
        return s
    return s[-1] + reverse_string(s[:-1])

def is_palindrome(s: str) -> bool:
    """Check if a string is a palindrome using recursion."""
    if len(s) <= 1:
        return True
    if s[0] != s[-1]:
        return False
    return is_palindrome(s[1:-1])

if __name__ == "__main__":
    print(reverse_string("hello"))      # expected: "olleh"
    print(is_palindrome("racecar"))     # expected: True
    print(is_palindrome("python"))      # expected: False
