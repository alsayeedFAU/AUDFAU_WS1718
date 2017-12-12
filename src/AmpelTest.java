public class AmpelTest {
	public static void main(String[] args) {

		Ampel ka = new KonkreteAmpel();

		System.out.println(ka.umschalten(500)); // * (1) *
		System.out.println(ka.umschaltZeit); // * (2) *

		AbstrakteAmpel ka2 = new KonkreteAmpel();

		System.out.println(ka2.umschaltZeit); // * (3) *

		KonkreteAmpel ka3 = new KonkreteAmpel();

		System.out.println(ka3.umschalten(500)); // * (4) *
		System.out.println(ka3.umschaltZeit); // * (5) *

		AlternativeAmpel kaa = new KonkreteAlternativeAmpel();

		System.out.println(kaa.umschalten(500)); // * (6) *
		System.out.println(kaa.umschaltZeit); // * (7) *

		KonkreteAlternativeAmpel kaa2 = new KonkreteAlternativeAmpel();

		System.out.println(kaa2.umschalten(500)); // * (8) *
		System.out.println(kaa2.umschaltZeit); // * (9) *
		System.out.println(kaa2.umschalten(500L)); // * (10) *
	}

}

abstract class AbstrakteAmpel implements Ampel {
	public String umschaltZeit = "Etwas arg lange";

	public String umschalten(int zeit) {
		return "AbstrakteAmpel.umschalten";
	}
}

class KonkreteAmpel extends AbstrakteAmpel implements Ampel {
	public String umschaltZeit = "Kurz und konkret";

	public String umschalten(long zeit) {
		return "Kurz, konkret, Knoellchen";
	}
}

class KonkreteAlternativeAmpel extends AbstrakteAmpel implements AlternativeAmpel {
	public int umschaltZeit = 42;

	public String umschalten(long zeit) {
		return "Umschalten, aber konkret!";
	}
}

interface Ampel {
	public long umschaltZeit = 666;

	public String umschalten(long zeit);
}

interface AlternativeAmpel {
	public static long umschaltZeit = 4711;

	public String umschalten(long zeit);
}
