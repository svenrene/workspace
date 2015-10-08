package wbs.enumeration;

public enum PlatonischerKoerper {
	Tetraeder {
		public int flaechen() {
			return 4;
		}

		public int kanten() {
			return 6;
		}

		public int ecken() {
			return 4;
		}
	},
	Oktaeder {
		public int flaechen() {
			return 8;
		}

		public int kanten() {
			return 12;
		}

		public int ecken() {
			return 6;
		}
	},
	Hexaeder {
		public int flaechen() {
			return 6;
		}

		public int kanten() {
			return 12;
		}

		public int ecken() {
			return 8;
		}
	},
	Ikosaeder {
		public int flaechen() {
			return 20;
		}

		public int kanten() {
			return 30;
		}

		public int ecken() {
			return 12;
		}
	},
	Dodekaeder {
		public int flaechen() {
			return 12;
		}

		public int kanten() {
			return 30;
		}

		public int ecken() {
			return 20;
		}
	};
	// class-body
	public abstract int flaechen();

	public abstract int kanten();

	public abstract int ecken();
}