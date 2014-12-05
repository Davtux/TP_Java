package exo1.adapteur;

public class TestFile {
	public static void main(String[] args) {
		final File<Integer> file = new FileImpl<Integer>();
		file.insererQueue(Integer.valueOf(10));
		file.insererQueue(Integer.valueOf(20));
		file.retirerTete();
		System.out.println(file.tete());
	}
}
