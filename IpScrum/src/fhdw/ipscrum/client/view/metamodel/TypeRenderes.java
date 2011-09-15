package fhdw.ipscrum.client.view.metamodel;

import java.util.Date;

import fhdw.ipscrum.client.architecture.widgets.TypedListBox.TypeRendere;
import fhdw.ipscrum.shared.model.nonMeta.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Hint;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

public final class TypeRenderes {

	/**
	 * constructor of the TypeRenderes.
	 */
	private TypeRenderes() {

	}

	public static final TypeRendere<fhdw.ipscrum.shared.model.nonMeta.System> SystemRenderer =
			new TypeRendere<fhdw.ipscrum.shared.model.nonMeta.System>() {

				@Override
				public String render(
						final fhdw.ipscrum.shared.model.nonMeta.System object) {
					return object.getName();
				}
			};
	public static final TypeRendere<Sprint> SprintRenderer = new TypeRendere<Sprint>() {

		@Override
		public String render(final Sprint object) {
			return object.getName();
		}
	};
	public static final TypeRendere<Release> ReleaseRenderer =
			new TypeRendere<Release>() {

				@Override
				public String render(final Release object) {
					return object.getVersion();
				}
			};
	public static final TypeRendere<Person> PersonRenderer = new TypeRendere<Person>() {

		@Override
		public String render(final Person object) {
			return object.getFirstname() + " " + object.getLastname();
		}
	};
	public static final TypeRendere<ProductBacklogItem> PbiRenderer =
			new TypeRendere<ProductBacklogItem>() {

				@Override
				public String render(final ProductBacklogItem object) {
					return object.getName();
				}
			};
	public static final TypeRendere<Hint> HintRenderer = new TypeRendere<Hint>() {

		@Override
		public String render(final Hint object) {
			return object.getContent();
		}
	};
	public static final TypeRendere<Effort> EffortRenderer = new TypeRendere<Effort>() {

		@Override
		public String render(final Effort object) {
			return object.toString();
		}
	};
	public static final TypeRendere<AcceptanceCriterion> AcceptanceCriterionRenderer =
			new TypeRendere<AcceptanceCriterion>() {

				@Override
				public String render(final AcceptanceCriterion object) {
					return object.getContent();
				}
			};
	static TypeRendere<String> StringRenderer = new TypeRendere<String>() {

		@Override
		public String render(final String object) {
			return object;
		}
	};
	static TypeRendere<Long> LongRenderer = new TypeRendere<Long>() {

		@Override
		public String render(final Long object) {
			return object.toString();
		}
	};
	static TypeRendere<Date> DateRenderer = new TypeRendere<Date>() {

		@Override
		public String render(final Date object) {
			return object.toString();
		}
	};

}
