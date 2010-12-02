package schoolalyzer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A tuple container for two objects.
 *
 */
public class Tuple<L, R> {

	private L left;
	private R right;

	public Tuple() {
	}

	public Tuple(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public void setLeft(L left) {
		this.left = left;
	}

	public R getRight() {
		return right;
	}

	public void setRight(R right) {
		this.right = right;
	}

	@Override
	public boolean equals(Object obj) {

		if (!obj.getClass().equals(this.getClass())) {
			return false;
		}

		Tuple<L, R> other = (Tuple<L, R>) obj;
		if (this.getLeft().equals(other.getLeft()) && this.getRight().equals(other.getRight())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 17 * hash + (this.left != null ? this.left.hashCode() : 0);
		hash = 17 * hash + (this.right != null ? this.right.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "(" + left.toString() + "," + right.toString() + ")";
	}

	public void setFromString(String s) {
		Pattern pattern = Pattern.compile("^\\((.*),(.*)\\)$");
		Matcher m = pattern.matcher(s);
		if (m.matches()) {
			String l = m.group(1);
			String r = m.group(2);
		} else {
			throw new IllegalArgumentException("Input string is not a tuple: '" + s + "'");
		}
	}
}
