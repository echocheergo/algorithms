package java;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] matched = new boolean[s.length() + 1][p.length() + 1];
        matched[0][0] = true;
        for (int j = 1; j < p.length(); j += 2) {
            if (p.charAt(j) == '*' && p.charAt(j - 1) != '*') {
                matched[0][j + 1] = matched[0][j - 1];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    matched[i + 1][j + 1] = matched[i][j];
                } else if (p.charAt(j) == '*' && j > 0 && p.charAt(j - 1) != '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        matched[i + 1][j + 1] = matched[i + 1][j - 1];
                    } else {
                        matched[i + 1][j + 1] = matched[i + 1][j - 1] || matched[i + 1][j] || matched[i][j + 1];
                    }
                }
            }
        }
        return matched[s.length()][p.length()];
    }
}
