public class GemischterBruch extends AbstrakterGemischterBruch {

	public GemischterBruch(long z, long n) {
		super((z < 0 && n >= 0) || (z >= 0 && n < 0) ? false : true, 0, z, n);
	}

	public GemischterBruch(long g, long z, long n) {
		super((z < 0 && n >= 0 && g >= 0) || (z >= 0 && n < 0 && g >= 0) || (z >= 0 && n >= 0 && g < 0)
				|| (z < 0 && n < 0 && g < 0) ? false : true, g, z, n);
	}

	@Override
	public int compareTo(AbstrakterGemischterBruch arg0) {
		if (istPositiv() && !istPositiv()) {
			return 1;
		}

		if (!istPositiv() && istPositiv()) {
			return -1;
		}

		if (istPositiv()) {
			GemischterBruch tmp = (GemischterBruch) this.subtrahiereDavon(arg0);
			return !tmp.istPositiv() ? -1 : tmp.holeZaehler() == 0 ? 0 : 1;
		}
		GemischterBruch tmp = (GemischterBruch) this.subtrahiereDavon(arg0);
		return !tmp.istPositiv() ? 1 : tmp.holeZaehler() == 0 ? 0 : -1;
	}

	@Override
	public AbstrakterGemischterBruch vereinfache() {
		long tmp = ggT(holeZaehler() % holeNenner(), holeNenner());
		long vorzeichen = istPositiv() ? 1 : -1;
		return new GemischterBruch(holeGanzzahligerAnteil() + holeZaehler() / holeNenner(),
				(holeZaehler() % holeNenner()) / tmp, vorzeichen * (holeNenner() / tmp));
	}

	@Override
	public AbstrakterGemischterBruch multipliziereMit(AbstrakterGemischterBruch andere) {
		// TODO Auto-generated method stub
		long vorzeichen = istPositiv() && !andere.istPositiv() || !istPositiv() && andere.istPositiv() ? -1 : 1;
		long z = (holeZaehler() + holeGanzzahligerAnteil() * holeNenner()) * andere.holeZaehler()
				+ andere.holeGanzzahligerAnteil() * andere.holeNenner();
		long n = holeNenner() * andere.holeNenner() * vorzeichen;

		return new GemischterBruch(z, n).vereinfache();
	}

	@Override
	public AbstrakterGemischterBruch dividiereDurch(AbstrakterGemischterBruch andere) {
		long vorzeichen = istPositiv() && !andere.istPositiv() || !istPositiv() && andere.istPositiv() ? -1 : 1;
		long z = (holeZaehler() + holeGanzzahligerAnteil() * holeNenner()) * andere.holeNenner();
		long n = holeNenner() * (andere.holeZaehler() + andere.holeGanzzahligerAnteil() * andere.holeNenner())
				* vorzeichen;
		return new GemischterBruch(z, n).vereinfache();
	}

	@Override
	public AbstrakterGemischterBruch addiereZu(AbstrakterGemischterBruch andere) {
		long vorzeichen1 = istPositiv() ? 1 : -1;
		long vorzeichen2 = andere.istPositiv() ? 1 : -1;
		long z = ((holeZaehler() + holeGanzzahligerAnteil() * holeNenner()) * andere.holeNenner() * vorzeichen1)
				+ ((andere.holeZaehler() + andere.holeGanzzahligerAnteil() * andere.holeNenner()) * holeNenner()
						* vorzeichen2);
		long n = holeNenner() * andere.holeNenner();
		return new GemischterBruch(z, n).vereinfache();
	}

	@Override
	public AbstrakterGemischterBruch subtrahiereDavon(AbstrakterGemischterBruch andere) {
		long vorzeichen1 = istPositiv() ? 1 : -1;
		long vorzeichen2 = andere.istPositiv() ? 1 : -1;
		long z = ((holeZaehler() + holeGanzzahligerAnteil() * holeNenner()) * andere.holeNenner() * vorzeichen1)
				- ((andere.holeZaehler() + andere.holeGanzzahligerAnteil() * andere.holeNenner()) * holeNenner()
						* vorzeichen2);
		long n = holeNenner() * andere.holeNenner();
		return new GemischterBruch(z, n).vereinfache();
	}

}
