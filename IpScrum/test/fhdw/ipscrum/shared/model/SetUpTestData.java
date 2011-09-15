package fhdw.ipscrum.shared.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Before;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * This class is needed to build a model with all aspects of the IPScrum, to deliver data
 * for the tests.
 */
public abstract class SetUpTestData {
	/**
	 * represents the model needed to use the IPScrum.
	 */
	protected Model model;
	/**
	 * represents the feature of the first sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr1fea1;
	/**
	 * represents the feature of the fifth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr5fea5;
	/**
	 * represents the feature of the first sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr1fea1;
	/**
	 * represents the feature of the first sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr1fea2;
	/**
	 * represents the feature of the first sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr1fea3;
	/**
	 * represents the feature of the first sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr1fea4;
	/**
	 * represents the feature of the first sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr1fea5;
	/**
	 * represents the feature of the second sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr2fea1;
	/**
	 * represents the feature of the second sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr2fea2;
	/**
	 * represents the feature of the second sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr2fea3;
	/**
	 * represents the feature of the second sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr2fea4;
	/**
	 * represents the feature of the second sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr2fea5;
	/**
	 * represents the feature of the third sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr3fea1;
	/**
	 * represents the feature of the third sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr3fea2;
	/**
	 * represents the feature of the third sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr3fea3;
	/**
	 * represents the feature of the third sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr3fea4;
	/**
	 * represents the feature of the third sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr3fea5;
	/**
	 * represents the feature of the fourth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr4fea1;
	/**
	 * represents the feature of the fourth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr4fea2;
	/**
	 * represents the feature of the fourth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr4fea3;
	/**
	 * represents the feature of the fourth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr4fea4;
	/**
	 * represents the feature of the fourth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr4fea5;
	/**
	 * represents the feature of the fifth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr5fea1;
	/**
	 * represents the feature of the fifth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr5fea2;
	/**
	 * represents the feature of the fifth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr5fea3;
	/**
	 * represents the feature of the fifth sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel1spr5fea4;
	/**
	 * represents the feature of the first sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr1fea2;
	/**
	 * represents the feature of the first sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr1fea3;
	/**
	 * represents the feature of the first sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr1fea4;
	/**
	 * represents the feature of the first sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr1fea5;
	/**
	 * represents the feature of the second sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr2fea1;
	/**
	 * represents the feature of the first sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr2fea2;
	/**
	 * represents the feature of the first sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr2fea3;
	/**
	 * represents the feature of the first sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr2fea4;
	/**
	 * represents the feature of the first sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr2fea5;
	/**
	 * represents the feature of the third sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr3fea1;
	/**
	 * represents the feature of the third sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr3fea2;
	/**
	 * represents the feature of the third sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr3fea3;
	/**
	 * represents the feature of the third sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr3fea4;
	/**
	 * represents the feature of the third sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr3fea5;
	/**
	 * represents the feature of the fourth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr4fea1;
	/**
	 * represents the feature of the fourth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr4fea2;
	/**
	 * represents the feature of the fourth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr4fea3;
	/**
	 * represents the feature of the fourth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr4fea4;
	/**
	 * represents the feature of the fourth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr4fea5;
	/**
	 * represents the feature of the fifth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr5fea1;
	/**
	 * represents the feature of the fifth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr5fea2;
	/**
	 * represents the feature of the fifth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr5fea3;
	/**
	 * represents the feature of the fifth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr5fea4;
	/**
	 * represents the feature of the fifth sprint of the second release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro1rel2spr5fea5;
	/**
	 * represents the feature of the first sprint of the first release of project one
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr1fea1;
	/**
	 * represents the feature of the first sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr1fea2;
	/**
	 * represents the feature of the first sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr1fea3;
	/**
	 * represents the feature of the first sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr1fea4;
	/**
	 * represents the feature of the first sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr1fea5;
	/**
	 * represents the feature of the second sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr2fea1;
	/**
	 * represents the feature of the second sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr2fea2;
	/**
	 * represents the feature of the second sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr2fea3;
	/**
	 * represents the feature of the second sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr2fea4;
	/**
	 * represents the feature of the second sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr2fea5;
	/**
	 * represents the feature of the third sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr3fea1;
	/**
	 * represents the feature of the third sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr3fea2;
	/**
	 * represents the feature of the third sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr3fea3;
	/**
	 * represents the feature of the third sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr3fea4;
	/**
	 * represents the feature of the third sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr3fea5;
	/**
	 * represents the feature of the fourth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr4fea1;
	/**
	 * represents the feature of the fourth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr4fea2;
	/**
	 * represents the feature of the fourth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr4fea3;
	/**
	 * represents the feature of the fourth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr4fea4;
	/**
	 * represents the feature of the fourth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr4fea5;
	/**
	 * represents the feature of the fifth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr5fea1;
	/**
	 * represents the feature of the fifth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr5fea2;
	/**
	 * represents the feature of the fifth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr5fea3;
	/**
	 * represents the feature of the fifth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr5fea4;
	/**
	 * represents the feature of the fifth sprint of the first release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel1spr5fea5;
	/**
	 * represents the feature of the first sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr1fea1;
	/**
	 * represents the feature of the first sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr1fea2;
	/**
	 * represents the feature of the first sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr1fea3;
	/**
	 * represents the feature of the first sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr1fea4;
	/**
	 * represents the feature of the first sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr1fea5;
	/**
	 * represents the feature of the second sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr2fea1;
	/**
	 * represents the feature of the second sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr2fea2;
	/**
	 * represents the feature of the second sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr2fea3;
	/**
	 * represents the feature of the second sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr2fea4;
	/**
	 * represents the feature of the second sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr2fea5;
	/**
	 * represents the feature of the third sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr3fea1;
	/**
	 * represents the feature of the third sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr3fea2;
	/**
	 * represents the feature of the third sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr3fea3;
	/**
	 * represents the feature of the third sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr3fea4;
	/**
	 * represents the feature of the third sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr3fea5;
	/**
	 * represents the feature of the fourth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr4fea1;
	/**
	 * represents the feature of the fourth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr4fea2;
	/**
	 * represents the feature of the fourth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr4fea3;
	/**
	 * represents the feature of the fourth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr4fea4;
	/**
	 * represents the feature of the fourth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr4fea5;
	/**
	 * represents the feature of the fifth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr5fea1;
	/**
	 * represents the feature of the fifth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr5fea2;
	/**
	 * represents the feature of the fifth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr5fea3;
	/**
	 * represents the feature of the fifth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr5fea4;
	/**
	 * represents the feature of the fifth sprint of the second release of project two
	 * which is needed to test complex things.
	 */
	protected Feature pro2rel2spr5fea5;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	protected Role roleTSUser;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	protected Role roleScrummaster;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	protected Role roleProductOwner;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	protected Role roleDeveloper;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	protected Role roleTester;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	protected Role roleGUIWiz;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	protected Person pSarah;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	protected Person pWilken;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	protected Person pChristin;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	protected Person pBjoern;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	protected Person pChris;
	/**
	 * represents one team needed to test complex things in the IPScrum.
	 */
	protected Team team1;
	/**
	 * represents one team needed to test complex things in the IPScrum.
	 */
	protected Team team2;
	/**
	 * represents one team needed to test complex things in the IPScrum.
	 */
	protected Team team3;
	/**
	 * represents one team needed to test complex things in the IPScrum.
	 */
	protected Team team4;
	/**
	 * represents one project needed to test complex things in the IPScrum.
	 */
	protected Project projekt1;
	/**
	 * represents one project needed to test complex things in the IPScrum.
	 */
	protected Project projekt2;
	/**
	 * represents the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	protected Release pro1rel1;
	/**
	 * represents the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	protected Release pro1rel2;
	/**
	 * represents the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	protected Release pro2rel1;
	/**
	 * represents the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	protected Release pro2rel2;
	/**
	 * represents the first sprint of the first release of project one which is needed to
	 * test complex things in the IPScrum.
	 */
	protected Sprint pro1rel1spr1;
	/**
	 * represents the second sprint of the first release of project one which is needed to
	 * test complex things in the IPScrum.
	 */
	protected Sprint pro1rel1spr2;
	/**
	 * represents the third sprint of the first release of project one which is needed to
	 * test complex things in the IPScrum.
	 */
	protected Sprint pro1rel1spr3;
	/**
	 * represents the fourth sprint of the first release of project one which is needed to
	 * test complex things in the IPScrum.
	 */
	protected Sprint pro1rel1spr4;
	/**
	 * represents the fifth sprint of the first release of project one which is needed to
	 * test complex things in the IPScrum.
	 */
	protected Sprint pro1rel1spr5;
	/**
	 * represents a sprint of the second release of project one which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro1rel2spr1;
	/**
	 * represents a sprint of the second release of project one which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro1rel2spr2;
	/**
	 * represents a sprint of the second release of project one which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro1rel2spr3;
	/**
	 * represents a sprint of the second release of project one which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro1rel2spr4;
	/**
	 * represents a sprint of the second release of project one which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro1rel2spr5;
	/**
	 * represents a sprint of the first release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel1spr1;
	/**
	 * represents a sprint of the first release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel1spr2;
	/**
	 * represents a sprint of the first release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel1spr3;
	/**
	 * represents a sprint of the first release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel1spr4;
	/**
	 * represents a sprint of the first release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel1spr5;
	/**
	 * represents a sprint of the second release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel2spr1;
	/**
	 * represents a sprint of the second release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel2spr2;
	/**
	 * represents a sprint of the second release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel2spr3;
	/**
	 * represents a sprint of the second release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel2spr4;
	/**
	 * represents a sprint of the second release of project two which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro2rel2spr5;
	/**
	 * represents a task of the first sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr1tas1;
	/**
	 * represents a task of the first sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr1tas2;
	/**
	 * represents a task of the first sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr1tas3;
	/**
	 * represents a task of the first sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr1tas4;
	/**
	 * represents a task of the first sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr1tas5;
	/**
	 * represents a task of the second sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr2tas1;
	/**
	 * represents a task of the second sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr2tas2;
	/**
	 * represents a task of the second sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr2tas3;
	/**
	 * represents a task of the second sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr2tas4;
	/**
	 * represents a task of the second sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr2tas5;
	/**
	 * represents a task of the third sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr3tas1;
	/**
	 * represents a task of the third sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr3tas2;
	/**
	 * represents a task of the third sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr3tas3;
	/**
	 * represents a task of the third sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr3tas4;
	/**
	 * represents a task of the third sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr3tas5;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr4tas1;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr4tas2;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr4tas3;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr4tas4;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr4tas5;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr5tas1;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr5tas2;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr5tas3;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr5tas4;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel1spr5tas5;
	/**
	 * represents a task of the first sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr1tas1;
	/**
	 * represents a task of the first sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr1tas2;
	/**
	 * represents a task of the first sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr1tas3;
	/**
	 * represents a task of the first sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr1tas4;
	/**
	 * represents a task of the first sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr1tas5;
	/**
	 * represents a task of the second sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr2tas1;
	/**
	 * represents a task of the second sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr2tas2;
	/**
	 * represents a task of the second sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr2tas3;
	/**
	 * represents a task of the second sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr2tas4;
	/**
	 * represents a task of the second sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr2tas5;
	/**
	 * represents a task of the third sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr3tas1;
	/**
	 * represents a task of the third sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr3tas2;
	/**
	 * represents a task of the third sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr3tas3;
	/**
	 * represents a task of the third sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr3tas4;
	/**
	 * represents a task of the third sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr3tas5;
	/**
	 * represents a task of the fourth sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr4tas1;
	/**
	 * represents a task of the fourth sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr4tas2;
	/**
	 * represents a task of the fourth sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr4tas3;
	/**
	 * represents a task of the fourth sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr4tas4;
	/**
	 * represents a task of the fourth sprint of the second release of project one which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr4tas5;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr5tas1;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr5tas2;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr5tas3;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr5tas4;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro1rel2spr5tas5;
	/**
	 * represents a task of the first sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr1tas1;
	/**
	 * represents a task of the first sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr1tas2;
	/**
	 * represents a task of the first sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr1tas3;
	/**
	 * represents a task of the first sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr1tas4;
	/**
	 * represents a task of the first sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr1tas5;
	/**
	 * represents a task of the second sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr2tas1;
	/**
	 * represents a task of the second sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr2tas2;
	/**
	 * represents a task of the second sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr2tas3;
	/**
	 * represents a task of the second sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr2tas4;
	/**
	 * represents a task of the second sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr2tas5;
	/**
	 * represents a task of the third sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr3tas1;
	/**
	 * represents a task of the third sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr3tas2;
	/**
	 * represents a task of the third sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr3tas3;
	/**
	 * represents a task of the third sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr3tas4;
	/**
	 * represents a task of the third sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr3tas5;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr4tas1;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr4tas2;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr4tas3;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr4tas4;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr4tas5;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr5tas2;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr5tas3;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr5tas4;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr5tas5;
	/**
	 * represents a task of the first sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr1tas1;
	/**
	 * represents a task of the first sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr1tas2;
	/**
	 * represents a task of the first sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr1tas3;
	/**
	 * represents a task of the first sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr1tas4;
	/**
	 * represents a task of the first sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr1tas5;
	/**
	 * represents a task of the second sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr2tas1;
	/**
	 * represents a task of the second sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr2tas2;
	/**
	 * represents a task of the second sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr2tas3;
	/**
	 * represents a task of the second sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr2tas4;
	/**
	 * represents a task of the second sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr2tas5;
	/**
	 * represents a task of the third sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr3tas1;
	/**
	 * represents a task of the third sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr3tas2;
	/**
	 * represents a task of the third sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr3tas3;
	/**
	 * represents a task of the third sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr3tas4;
	/**
	 * represents a task of the third sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr3tas5;
	/**
	 * represents a task of the fourth sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr4tas2;
	/**
	 * represents a task of the fourth sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr4tas1;
	/**
	 * represents a task of the fourth sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr4tas3;
	/**
	 * represents a task of the fourth sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr4tas4;
	/**
	 * represents a task of the fourth sprint of the second release of project two which
	 * is needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr4tas5;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr5tas1;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr5tas2;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr5tas3;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr5tas4;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel2spr5tas5;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is
	 * needed to test complex things in the IPScrum.
	 */
	protected Task pro2rel1spr5tas1;
	/**
	 * represents a project which is needed to test complex things in the IPScrum.
	 */
	protected Project projekt3;
	/**
	 * represents the first release of project three which is needed to test complex
	 * things in the IPScrum.
	 */
	protected Release pro3rel1;
	/**
	 * represents the second release of project three which is needed to test complex
	 * things in the IPScrum.
	 */
	protected Release pro3rel2;
	/**
	 * represents a sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel1spr1;
	/**
	 * represents a sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel1spr2;
	/**
	 * represents a sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel1spr3;
	/**
	 * represents a sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel1spr4;
	/**
	 * represents a sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel1spr5;
	/**
	 * represents a sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel2spr1;
	/**
	 * represents a sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel2spr2;
	/**
	 * represents a sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel2spr3;
	/**
	 * represents a sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel2spr4;
	/**
	 * represents a sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	protected Sprint pro3rel2spr5;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel1spr1fea1;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr1fea2;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr1fea3;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr1fea4;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr1fea5;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr2fea1;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr2fea2;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel1spr2fea3;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel1spr2fea4;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr2fea5;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr3fea1;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr3fea2;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel1spr3fea3;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr3fea4;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr3fea5;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel1spr4fea1;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr4fea2;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr4fea3;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr4fea4;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr4fea5;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel1spr5fea1;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr5fea2;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel1spr5fea3;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel1spr5fea4;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel1spr5fea5;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr1fea1;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr1fea2;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr1fea3;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr1fea4;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr1fea5;
	/**
	 * represents a bug/feature of the second sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr2fea1;
	/**
	 * represents a bug/feature of the second sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr2fea2;
	/**
	 * represents a bug/feature of the second sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr2fea3;
	/**
	 * represents a bug/feature of the second sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr2fea4;
	/**
	 * represents a bug/feature of the second sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr2fea5;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr3fea1;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr3fea2;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr3fea3;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr3fea4;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr3fea5;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr4fea1;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr4fea2;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr4fea3;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr4fea4;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project
	 * three which is needed to test complex things in the IPScrum.
	 */
	protected Feature pro3rel2spr4fea5;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr5fea1;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr5fea2;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr5fea3;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr5fea4;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three
	 * which is needed to test complex things in the IPScrum.
	 */
	protected Bug pro3rel2spr5fea5;
	/**
	 * represents a list of feature which is needed to test complex things in the IPScrum.
	 */
	public Collection<ProductBacklogItem> listOfFeatures;

	/**
	 * gets the model of the class.
	 * 
	 * @return the model to test
	 */
	public Model getModel() {
		return this.model;
	}

	/**
	 * sets up the date before evey test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model =
				ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
		new RelationType(this.model, "Abhängig von");
		new RelationType(this.model, "Siehe auch");

		this.roleTSUser = new Role(this.model, "Ticketsystem-Benutzer");

		this.roleScrummaster = new Role(this.model, "Scrum-Master");
		this.roleProductOwner = new Role(this.model, "Product-Owner");
		this.roleDeveloper = new Role(this.model, "Entwickler");
		this.roleTester = new Role(this.model, "Tester");
		this.roleGUIWiz = new Role(this.model, "GUI-Wizard");

		// Initial Persons
		this.pSarah = new Person(this.model, "Sarah", "Gottwald");
		this.pSarah.addRole(this.roleScrummaster);
		this.pSarah.addRole(this.roleTSUser);

		this.pWilken = new Person(this.model, "Wilken", "Hustedt");
		this.pWilken.addRole(this.roleDeveloper);
		this.pWilken.addRole(this.roleGUIWiz);
		this.pWilken.addRole(this.roleTSUser);

		this.pChristin = new Person(this.model, "Christin", "Weckbrod");
		this.pChristin.addRole(this.roleProductOwner);
		this.pChristin.addRole(this.roleDeveloper);
		this.pChristin.addRole(this.roleTSUser);

		this.pBjoern = new Person(this.model, "Björn", "Bodensieck");
		this.pBjoern.addRole(this.roleTester);
		this.pBjoern.addRole(this.roleTSUser);

		this.pChris = new Person(this.model, "Christoph", "Stürzekarn");
		this.pChris.addRole(this.roleTester);
		this.pChris.addRole(this.roleDeveloper);
		this.pChris.addRole(this.roleTSUser);

		// Initial Teams
		this.team1 = new Team(this.model, "Frontend");
		this.team1.addMember(this.pSarah);
		this.team1.addMember(this.pWilken);
		this.team1.addMember(this.pBjoern);

		this.team2 = new Team(this.model, "Backend");
		this.team2.addMember(this.pChristin);

		this.team3 = new Team(this.model, "Reporting");
		this.team3.addMember(this.pChris);
		this.team3.addMember(this.pSarah);
		this.team3.addMember(this.pWilken);

		this.team4 = new Team(this.model, "Testing");
		this.team4.addMember(this.pChris);
		this.team4.addMember(this.pBjoern);

		// Initial Projects
		this.projekt1 = new Project(this.model, "Projekt 1");
		this.projekt2 = new Project(this.model, "Projekt 2");
		this.projekt3 = new Project(this.model, "Projekt 3");

		this.team1.addProject(this.projekt1);
		this.team1.addProject(this.projekt2);
		this.team1.addProject(this.projekt3);
		this.team2.addProject(this.projekt1);
		this.team2.addProject(this.projekt2);
		this.team2.addProject(this.projekt3);
		this.team3.addProject(this.projekt1);
		this.team3.addProject(this.projekt2);
		this.team3.addProject(this.projekt3);
		this.team4.addProject(this.projekt1);
		this.team4.addProject(this.projekt2);
		this.team4.addProject(this.projekt3);

		// Initial Releases
		this.pro1rel1 =
				new Release(this.model, "1.0", CalendarUtils.getRandomReleaseDate(),
						this.projekt1);
		this.pro1rel2 =
				new Release(this.model, "2.0", CalendarUtils.getRandomReleaseDate(),
						this.projekt1);
		this.pro2rel1 =
				new Release(this.model, "1.0", CalendarUtils.getRandomReleaseDate(),
						this.projekt2);
		this.pro2rel2 =
				new Release(this.model, "2.0", CalendarUtils.getRandomReleaseDate(),
						this.projekt2);
		this.pro3rel1 =
				new Release(this.model, "1.0", CalendarUtils.getRandomReleaseDate(),
						this.projekt3);
		this.pro3rel2 =
				new Release(this.model, "2.0", CalendarUtils.getRandomReleaseDate(),
						this.projekt3);

		// Initial Sprints
		// Für Projekt 1, Release 1
		// final Date pro1rel1spr1BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr1EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr1BeginDate, this.pro1rel1.getReleaseDate());
		this.pro1rel1spr1 =
				new Sprint(this.model, "Pro1Rel1Sprint1", "Beschreibung Sprint 1",
						new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 2 - 1,
								28), this.team1, this.projekt1);

		// final Date pro1rel1spr2BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr2EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr2BeginDate, this.pro1rel1.getReleaseDate());
		this.pro1rel1spr2 =
				new Sprint(this.model, "Pro1Rel1Sprint2", "Beschreibung Sprint 2",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt1);

		// final Date pro1rel1spr3BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr3EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr3BeginDate, this.pro1rel1.getReleaseDate());
		this.pro1rel1spr3 =
				new Sprint(this.model, "Pro1Rel1Sprint3", "Beschreibung Sprint 3",
						new Date(2011 - 1900, 1 - 1, 1), new Date(2011 - 1900, 1 - 1,
								31), this.team1, this.projekt1);

		// final Date pro1rel1spr4BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr4EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr4BeginDate, this.pro1rel1.getReleaseDate());
		this.pro1rel1spr4 =
				new Sprint(this.model, "Pro1Rel1Sprint4", "Beschreibung Sprint 4",
						new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt1);

		// final Date pro1rel1spr5BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr5EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr5BeginDate, this.pro1rel1.getReleaseDate());
		this.pro1rel1spr5 =
				new Sprint(this.model, "Pro1Rel1Sprint5", "Beschreibung Sprint 5",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt1);

		// Für Projekt 1, Release 2
		// final Date pro1rel2spr1BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel2spr1EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel2spr1BeginDate, this.pro1rel2.getReleaseDate());
		this.pro1rel2spr1 =
				new Sprint(this.model, "Pro1Rel2Sprint1", "Beschreibung Sprint 1",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt1);

		// final Date pro1rel2spr2BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel2spr2EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel2spr2BeginDate, this.pro1rel2.getReleaseDate());
		this.pro1rel2spr2 =
				new Sprint(this.model, "Pro1Rel2Sprint2", "Beschreibung Sprint 2",
						new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt1);

		final Date pro1rel2spr3BeginDate = new Date();
		final Date pro1rel2spr3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(pro1rel2spr3EndDate, 4);
		this.pro1rel2spr3 =
				new Sprint(this.model, "Pro1Rel2Sprint3", "Beschreibung Sprint 3",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt1);

		final Date pro1rel2spr4BeginDate = new Date();
		final Date pro1rel2spr4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(pro1rel2spr4EndDate, 1);
		this.pro1rel2spr4 =
				new Sprint(this.model, "Pro1Rel2Sprint4", "Beschreibung Sprint 4",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt1);

		final Date pro1rel2spr5BeginDate = new Date();
		final Date pro1rel2spr5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(pro1rel2spr5EndDate, 4);
		this.pro1rel2spr5 =
				new Sprint(this.model, "Pro1Rel2Sprint5", "Beschreibung Sprint 5",
						new Date(2011 - 1900, 4 - 1, 1), new Date(2011 - 1900, 4 - 1,
								30), this.team1, this.projekt1);

		// Für Projekt 2, Release 1
		// final Date pro2rel1spr1BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro2rel1spr1EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro2rel1spr1BeginDate, this.pro2rel1.getReleaseDate());
		this.pro2rel1spr1 =
				new Sprint(this.model, "Pro2Rel1Sprint1", "Beschreibung Sprint 1",
						new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 4 - 1,
								30), this.team1, this.projekt2);

		// final Date pro2rel1spr2BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro2rel1spr2EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro2rel1spr2BeginDate, this.pro2rel1.getReleaseDate());
		this.pro2rel1spr2 =
				new Sprint(this.model, "Pro2Rel1Sprint2", "Beschreibung Sprint 2",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt2);

		final Date pro2rel1spr3BeginDate = new Date();
		final Date pro2rel1spr3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(pro2rel1spr3EndDate, 4);
		this.pro2rel1spr3 =
				new Sprint(this.model, "Pro2Rel1Sprint3", "Beschreibung Sprint 3",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 4 - 1,
								30), this.team1, this.projekt2);

		final Date pro2rel1spr4BeginDate = new Date();
		final Date pro2rel1spr4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(pro2rel1spr4EndDate, 1);
		this.pro2rel1spr4 =
				new Sprint(this.model, "Pro2Rel1Sprint4", "Beschreibung Sprint 4",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt2);

		final Date pro2rel1spr5BeginDate = new Date();
		final Date pro2rel1spr5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(pro2rel1spr5EndDate, 4);
		this.pro2rel1spr5 =
				new Sprint(this.model, "Pro2Rel1Sprint5", "Beschreibung Sprint 5",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt2);

		// Für Projekt 2, Release 2
		// final Date sprint6BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint6EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint6BeginDate, this.pro2rel2.getReleaseDate());
		this.pro2rel2spr1 =
				new Sprint(this.model, "Pro2Rel2Sprint1", "Beschreibung Sprint 1",
						new Date(2011 - 1900, 6 - 1, 1), new Date(2011 - 1900, 6 - 1,
								30), this.team1, this.projekt2);

		// final Date sprint7BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint7EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint7BeginDate, this.pro2rel2.getReleaseDate());
		this.pro2rel2spr2 =
				new Sprint(this.model, "Pro2Rel2Sprint2", "Beschreibung Sprint 2",
						new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt2);

		// final Date sprint8BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint8EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint8BeginDate, this.pro2rel2.getReleaseDate());
		this.pro2rel2spr3 =
				new Sprint(this.model, "Pro2Rel2Sprint3", "Beschreibung Sprint 3",
						new Date(2011 - 1900, 1 - 1, 1), new Date(2011 - 1900, 1 - 1,
								31), this.team1, this.projekt2);

		// final Date sprint9BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint9EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint9BeginDate, this.pro2rel2.getReleaseDate());
		this.pro2rel2spr4 =
				new Sprint(this.model, "Pro2Rel2Sprint4", "Beschreibung Sprint 4",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt2);

		// final Date sprint10BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint10EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint10BeginDate, this.pro2rel2.getReleaseDate());
		this.pro2rel2spr5 =
				new Sprint(this.model, "Pro2Rel2Sprint5", "Beschreibung Sprint 5",
						new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team1, this.projekt2);

		// Für Projekt 3, Release 1
		this.pro3rel1spr1 =
				new Sprint(this.model, "Pro3Rel1Sprint1", "Beschreibung Sprint 1",
						new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 2 - 1,
								28), this.team4, this.projekt3);
		this.pro3rel1spr2 =
				new Sprint(this.model, "Pro3Rel1Sprint2", "Beschreibung Sprint 2",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team4, this.projekt3);
		this.pro3rel1spr3 =
				new Sprint(this.model, "Pro3Rel1Sprint3", "Beschreibung Sprint 3",
						new Date(2011 - 1900, 1 - 1, 1), new Date(2011 - 1900, 1 - 1,
								31), this.team4, this.projekt3);
		this.pro3rel1spr4 =
				new Sprint(this.model, "Pro3Rel1Sprint4", "Beschreibung Sprint 4",
						new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team4, this.projekt3);
		this.pro3rel1spr5 =
				new Sprint(this.model, "Pro3Rel1Sprint5", "Beschreibung Sprint 5",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team4, this.projekt3);

		// Für Projekt 3, Release 2
		this.pro3rel2spr1 =
				new Sprint(this.model, "Pro3Rel2Sprint1", "Beschreibung Sprint 1",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team4, this.projekt3);
		this.pro3rel2spr2 =
				new Sprint(this.model, "Pro3Rel2Sprint2", "Beschreibung Sprint 2",
						new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team4, this.projekt3);
		this.pro3rel2spr3 =
				new Sprint(this.model, "Pro3Rel2Sprint3", "Beschreibung Sprint 3",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team4, this.projekt3);
		this.pro3rel2spr4 =
				new Sprint(this.model, "Pro3Rel2Sprint4", "Beschreibung Sprint 4",
						new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
								31), this.team4, this.projekt3);
		this.pro3rel2spr5 =
				new Sprint(this.model, "Pro3Rel2Sprint5", "Beschreibung Sprint 5",
						new Date(2011 - 1900, 4 - 1, 1), new Date(2011 - 1900, 4 - 1,
								30), this.team4, this.projekt3);

		// Initial Features
		// für Projekt 1, Release 1, Sprint 1
		final FeatureTicketType featureTicketType =
				this.model.getTypeManager().getStandardFeatureType();
		final StateType closedState = this.model.getTypeManager().getClosed();
		final BugTicketType bugTicketType =
				this.model.getTypeManager().getStandardBugType();
		this.pro1rel1spr1fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 1, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel1spr1fea1.setLastEditor(this.pBjoern);
		this.pro1rel1spr1fea1.setManDayCosts(new Effort(3));
		this.pro1rel1spr1fea1.setSprint(this.pro1rel1spr1);
		this.pro1rel1spr1fea1.changeState(closedState);

		this.pro1rel1spr1fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 1, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel1spr1fea2.setLastEditor(this.pBjoern);
		this.pro1rel1spr1fea2.setManDayCosts(new Effort(4));
		this.pro1rel1spr1fea2.setSprint(this.pro1rel1spr1);
		this.pro1rel1spr1fea2.changeState(closedState);

		this.pro1rel1spr1fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 1, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel1spr1fea3.setLastEditor(this.pBjoern);
		this.pro1rel1spr1fea3.setManDayCosts(new Effort(5));
		this.pro1rel1spr1fea3.setSprint(this.pro1rel1spr1);
		// pro1rel1spr1fea3.changeState(closedState);

		this.pro1rel1spr1fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 1, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel1spr1fea4.setLastEditor(this.pBjoern);
		this.pro1rel1spr1fea4.setManDayCosts(new Effort(4));
		this.pro1rel1spr1fea4.setSprint(this.pro1rel1spr1);
		// pro1rel1spr1fea4.changeState(closedState);

		this.pro1rel1spr1fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 1, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel1spr1fea5.setLastEditor(this.pBjoern);
		this.pro1rel1spr1fea5.setManDayCosts(new Effort(3));
		this.pro1rel1spr1fea5.setSprint(this.pro1rel1spr1);
		this.pro1rel1spr1fea5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 2
		this.pro1rel1spr2fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 2, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel1spr2fea1.setLastEditor(this.pBjoern);
		this.pro1rel1spr2fea1.setManDayCosts(new Effort(2));
		this.pro1rel1spr2fea1.setSprint(this.pro1rel1spr2);
		this.pro1rel1spr2fea1.changeState(closedState);

		this.pro1rel1spr2fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 2, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel1spr2fea2.setLastEditor(this.pBjoern);
		this.pro1rel1spr2fea2.setManDayCosts(new Effort(10));
		this.pro1rel1spr2fea2.setSprint(this.pro1rel1spr2);
		// pro1rel1spr2fea2.changeState(closedState);

		this.pro1rel1spr2fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 2, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel1spr2fea3.setLastEditor(this.pBjoern);
		this.pro1rel1spr2fea3.setManDayCosts(new Effort(15));
		this.pro1rel1spr2fea3.setSprint(this.pro1rel1spr2);
		this.pro1rel1spr2fea3.changeState(closedState);

		this.pro1rel1spr2fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 2, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel1spr2fea4.setLastEditor(this.pBjoern);
		this.pro1rel1spr2fea4.setManDayCosts(new Effort(3));
		this.pro1rel1spr2fea4.setSprint(this.pro1rel1spr2);
		this.pro1rel1spr2fea4.changeState(closedState);

		this.pro1rel1spr2fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 2, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel1spr2fea5.setLastEditor(this.pBjoern);
		this.pro1rel1spr2fea5.setManDayCosts(new Effort(6));
		this.pro1rel1spr2fea5.setSprint(this.pro1rel1spr2);
		// pro1rel1spr2fea5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 3
		this.pro1rel1spr3fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 3, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel1spr3fea1.setLastEditor(this.pBjoern);
		this.pro1rel1spr3fea1.setManDayCosts(new Effort(20));
		this.pro1rel1spr3fea1.setSprint(this.pro1rel1spr3);
		// pro1rel1spr3fea1.changeState(closedState);

		this.pro1rel1spr3fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 3, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel1spr3fea2.setLastEditor(this.pBjoern);
		this.pro1rel1spr3fea2.setManDayCosts(new Effort(6));
		this.pro1rel1spr3fea2.setSprint(this.pro1rel1spr3);
		// pro1rel1spr3fea2.changeState(closedState);

		this.pro1rel1spr3fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 3, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel1spr3fea3.setLastEditor(this.pBjoern);
		this.pro1rel1spr3fea3.setManDayCosts(new Effort(48));
		this.pro1rel1spr3fea3.setSprint(this.pro1rel1spr3);
		this.pro1rel1spr3fea3.changeState(closedState);

		this.pro1rel1spr3fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 3, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel1spr3fea4.setLastEditor(this.pBjoern);
		this.pro1rel1spr3fea4.setManDayCosts(new Effort(2));
		this.pro1rel1spr3fea4.setSprint(this.pro1rel1spr3);
		this.pro1rel1spr3fea4.changeState(closedState);

		this.pro1rel1spr3fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 3, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel1spr3fea5.setLastEditor(this.pBjoern);
		this.pro1rel1spr3fea5.setManDayCosts(new Effort(1));
		this.pro1rel1spr3fea5.setSprint(this.pro1rel1spr3);
		// pro1rel1spr3fea5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 4
		this.pro1rel1spr4fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 4, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel1spr4fea1.setLastEditor(this.pBjoern);
		this.pro1rel1spr4fea1.setManDayCosts(new Effort(4));
		this.pro1rel1spr4fea1.setSprint(this.pro1rel1spr4);
		// pro1rel1spr4fea1.changeState(closedState);

		this.pro1rel1spr4fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 4, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel1spr4fea2.setLastEditor(this.pBjoern);
		this.pro1rel1spr4fea2.setManDayCosts(new Effort(10));
		this.pro1rel1spr4fea2.setSprint(this.pro1rel1spr4);
		// pro1rel1spr4fea2.changeState(closedState);

		this.pro1rel1spr4fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 4, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel1spr4fea3.setLastEditor(this.pBjoern);
		this.pro1rel1spr4fea3.setManDayCosts(new Effort(5));
		this.pro1rel1spr4fea3.setSprint(this.pro1rel1spr4);
		// pro1rel1spr4fea3.changeState(closedState);

		this.pro1rel1spr4fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 4, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel1spr4fea4.setLastEditor(this.pBjoern);
		this.pro1rel1spr4fea4.setManDayCosts(new Effort(9));
		this.pro1rel1spr4fea4.setSprint(this.pro1rel1spr4);
		// pro1rel1spr4fea4.changeState(closedState);

		this.pro1rel1spr4fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 4, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel1spr4fea5.setLastEditor(this.pBjoern);
		this.pro1rel1spr4fea5.setManDayCosts(new Effort(3));
		this.pro1rel1spr4fea5.setSprint(this.pro1rel1spr4);
		// pro1rel1spr4fea5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 5
		this.pro1rel1spr5fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 5, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel1spr5fea1.setLastEditor(this.pBjoern);
		this.pro1rel1spr5fea1.setManDayCosts(new Effort(16));
		this.pro1rel1spr5fea1.setSprint(this.pro1rel1spr5);
		this.pro1rel1spr5fea1.changeState(closedState);

		this.pro1rel1spr5fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 5, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel1spr5fea2.setLastEditor(this.pBjoern);
		this.pro1rel1spr5fea2.setManDayCosts(new Effort(4));
		this.pro1rel1spr5fea2.setSprint(this.pro1rel1spr5);
		this.pro1rel1spr5fea2.changeState(closedState);

		this.pro1rel1spr5fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 5, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel1spr5fea3.setLastEditor(this.pBjoern);
		this.pro1rel1spr5fea3.setManDayCosts(new Effort(5));
		this.pro1rel1spr5fea3.setSprint(this.pro1rel1spr5);
		this.pro1rel1spr5fea3.changeState(closedState);

		this.pro1rel1spr5fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 5, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel1spr5fea4.setLastEditor(this.pBjoern);
		this.pro1rel1spr5fea4.setManDayCosts(new Effort(35));
		this.pro1rel1spr5fea4.setSprint(this.pro1rel1spr5);
		this.pro1rel1spr5fea4.changeState(closedState);

		this.pro1rel1spr5fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 1, Sprint 5, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel1spr5fea5.setLastEditor(this.pBjoern);
		this.pro1rel1spr5fea5.setManDayCosts(new Effort(3));
		this.pro1rel1spr5fea5.setSprint(this.pro1rel1spr5);
		this.pro1rel1spr5fea5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 1
		this.pro1rel2spr1fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 1, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel2spr1fea1.setLastEditor(this.pBjoern);
		this.pro1rel2spr1fea1.setManDayCosts(new Effort(80));
		this.pro1rel2spr1fea1.setSprint(this.pro1rel2spr1);
		this.pro1rel2spr1fea1.changeState(closedState);

		this.pro1rel2spr1fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 1, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel2spr1fea2.setLastEditor(this.pBjoern);
		this.pro1rel2spr1fea2.setManDayCosts(new Effort(20));
		this.pro1rel2spr1fea2.setSprint(this.pro1rel2spr1);
		// pro1rel2spr1fea2.changeState(closedState);

		this.pro1rel2spr1fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 1, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel2spr1fea3.setLastEditor(this.pBjoern);
		this.pro1rel2spr1fea3.setManDayCosts(new Effort(5));
		this.pro1rel2spr1fea3.setSprint(this.pro1rel2spr1);
		this.pro1rel2spr1fea3.changeState(closedState);

		this.pro1rel2spr1fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 1, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel2spr1fea4.setLastEditor(this.pBjoern);
		this.pro1rel2spr1fea4.setManDayCosts(new Effort(4));
		this.pro1rel2spr1fea4.setSprint(this.pro1rel2spr1);
		this.pro1rel2spr1fea4.changeState(closedState);

		this.pro1rel2spr1fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 1, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel2spr1fea5.setLastEditor(this.pBjoern);
		this.pro1rel2spr1fea5.setManDayCosts(new Effort(3));
		this.pro1rel2spr1fea5.setSprint(this.pro1rel2spr1);
		this.pro1rel2spr1fea5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 2
		this.pro1rel2spr2fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 2, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel2spr2fea1.setLastEditor(this.pBjoern);
		this.pro1rel2spr2fea1.setManDayCosts(new Effort(5));
		this.pro1rel2spr2fea1.setSprint(this.pro1rel2spr2);
		// pro1rel2spr2fea1.changeState(closedState);

		this.pro1rel2spr2fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 2, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel2spr2fea2.setLastEditor(this.pBjoern);
		this.pro1rel2spr2fea2.setManDayCosts(new Effort(20));
		this.pro1rel2spr2fea2.setSprint(this.pro1rel2spr2);
		// pro1rel2spr2fea2.changeState(closedState);

		this.pro1rel2spr2fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 2, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel2spr2fea3.setLastEditor(this.pBjoern);
		this.pro1rel2spr2fea3.setManDayCosts(new Effort(5));
		this.pro1rel2spr2fea3.setSprint(this.pro1rel2spr2);
		// pro1rel2spr2fea3.changeState(closedState);

		this.pro1rel2spr2fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 2, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel2spr2fea4.setLastEditor(this.pBjoern);
		this.pro1rel2spr2fea4.setManDayCosts(new Effort(6));
		this.pro1rel2spr2fea4.setSprint(this.pro1rel2spr2);
		this.pro1rel2spr2fea4.changeState(closedState);

		this.pro1rel2spr2fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 2, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel2spr2fea5.setLastEditor(this.pBjoern);
		this.pro1rel2spr2fea5.setManDayCosts(new Effort(35));
		this.pro1rel2spr2fea5.setSprint(this.pro1rel2spr2);
		this.pro1rel2spr2fea5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 3
		this.pro1rel2spr3fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 3, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel2spr3fea1.setLastEditor(this.pBjoern);
		this.pro1rel2spr3fea1.setManDayCosts(new Effort(13));
		this.pro1rel2spr3fea1.setSprint(this.pro1rel2spr3);
		this.pro1rel2spr3fea1.changeState(closedState);

		this.pro1rel2spr3fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 3, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel2spr3fea2.setLastEditor(this.pBjoern);
		this.pro1rel2spr3fea2.setManDayCosts(new Effort(7));
		this.pro1rel2spr3fea2.setSprint(this.pro1rel2spr3);
		this.pro1rel2spr3fea2.changeState(closedState);

		this.pro1rel2spr3fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 3, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel2spr3fea3.setLastEditor(this.pBjoern);
		this.pro1rel2spr3fea3.setManDayCosts(new Effort(100));
		this.pro1rel2spr3fea3.setSprint(this.pro1rel2spr3);
		// pro1rel2spr3fea3.changeState(closedState);

		this.pro1rel2spr3fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 3, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel2spr3fea4.setLastEditor(this.pBjoern);
		this.pro1rel2spr3fea4.setManDayCosts(new Effort(83));
		this.pro1rel2spr3fea4.setSprint(this.pro1rel2spr3);
		this.pro1rel2spr3fea4.changeState(closedState);

		this.pro1rel2spr3fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 3, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel2spr3fea5.setLastEditor(this.pBjoern);
		this.pro1rel2spr3fea5.setManDayCosts(new Effort(3));
		this.pro1rel2spr3fea5.setSprint(this.pro1rel2spr3);
		// pro1rel2spr3fea5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 4
		this.pro1rel2spr4fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 4, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel2spr4fea1.setLastEditor(this.pBjoern);
		this.pro1rel2spr4fea1.setManDayCosts(new Effort(20));
		this.pro1rel2spr4fea1.setSprint(this.pro1rel2spr4);
		this.pro1rel2spr4fea1.changeState(closedState);

		this.pro1rel2spr4fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 4, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel2spr4fea2.setLastEditor(this.pBjoern);
		this.pro1rel2spr4fea2.setManDayCosts(new Effort(14));
		this.pro1rel2spr4fea2.setSprint(this.pro1rel2spr4);
		// pro1rel2spr4fea2.changeState(closedState);

		this.pro1rel2spr4fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 4, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel2spr4fea3.setLastEditor(this.pBjoern);
		this.pro1rel2spr4fea3.setManDayCosts(new Effort(80));
		this.pro1rel2spr4fea3.setSprint(this.pro1rel2spr4);
		this.pro1rel2spr4fea3.changeState(closedState);

		this.pro1rel2spr4fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 4, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel2spr4fea4.setLastEditor(this.pBjoern);
		this.pro1rel2spr4fea4.setManDayCosts(new Effort(12));
		this.pro1rel2spr4fea4.setSprint(this.pro1rel2spr4);
		// pro1rel2spr4fea4.changeState(closedState);

		this.pro1rel2spr4fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 4, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel2spr4fea5.setLastEditor(this.pBjoern);
		this.pro1rel2spr4fea5.setManDayCosts(new Effort(16));
		this.pro1rel2spr4fea5.setSprint(this.pro1rel2spr4);
		this.pro1rel2spr4fea5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 5
		this.pro1rel2spr5fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 5, Feature 1",
						"Beschreibung Feature 1", this.projekt1.getBacklog());
		this.pro1rel2spr5fea1.setLastEditor(this.pBjoern);
		this.pro1rel2spr5fea1.setManDayCosts(new Effort(13));
		this.pro1rel2spr5fea1.setSprint(this.pro1rel2spr5);
		// pro1rel2spr5fea1.changeState(closedState);

		this.pro1rel2spr5fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 5, Feature 2",
						"Beschreibung Feature 2", this.projekt1.getBacklog());
		this.pro1rel2spr5fea2.setLastEditor(this.pBjoern);
		this.pro1rel2spr5fea2.setManDayCosts(new Effort(14));
		this.pro1rel2spr5fea2.setSprint(this.pro1rel2spr5);
		this.pro1rel2spr5fea2.changeState(closedState);

		this.pro1rel2spr5fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 5, Feature 3",
						"Beschreibung Feature 3", this.projekt1.getBacklog());
		this.pro1rel2spr5fea3.setLastEditor(this.pBjoern);
		this.pro1rel2spr5fea3.setManDayCosts(new Effort(5));
		this.pro1rel2spr5fea3.setSprint(this.pro1rel2spr5);
		this.pro1rel2spr5fea3.changeState(closedState);

		this.pro1rel2spr5fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 5, Feature 4",
						"Beschreibung Feature 4", this.projekt1.getBacklog());
		this.pro1rel2spr5fea4.setLastEditor(this.pBjoern);
		this.pro1rel2spr5fea4.setManDayCosts(new Effort(4));
		this.pro1rel2spr5fea4.setSprint(this.pro1rel2spr5);
		// pro1rel2spr5fea4.changeState(closedState);

		this.pro1rel2spr5fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 1, Release 2, Sprint 5, Feature 5",
						"Beschreibung Feature 5", this.projekt1.getBacklog());
		this.pro1rel2spr5fea5.setLastEditor(this.pBjoern);
		this.pro1rel2spr5fea5.setManDayCosts(new Effort(3));
		this.pro1rel2spr5fea5.setSprint(this.pro1rel2spr5);
		this.pro1rel2spr5fea5.changeState(closedState);

		// für Projekt 2, Release 1, Sprint 1
		this.pro2rel1spr1fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 1, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel1spr1fea1.setLastEditor(this.pBjoern);
		this.pro2rel1spr1fea1.setManDayCosts(new Effort(3));
		this.pro2rel1spr1fea1.setSprint(this.pro2rel1spr1);
		// pro2rel1spr1fea1.changeState(closedState);

		this.pro2rel1spr1fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 1, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel1spr1fea2.setLastEditor(this.pBjoern);
		this.pro2rel1spr1fea2.setManDayCosts(new Effort(4));
		this.pro2rel1spr1fea2.setSprint(this.pro2rel1spr1);
		this.pro2rel1spr1fea2.changeState(closedState);

		this.pro2rel1spr1fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 1, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel1spr1fea3.setLastEditor(this.pBjoern);
		this.pro2rel1spr1fea3.setManDayCosts(new Effort(5));
		this.pro2rel1spr1fea3.setSprint(this.pro2rel1spr1);
		this.pro2rel1spr1fea3.changeState(closedState);

		this.pro2rel1spr1fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 1, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel1spr1fea4.setLastEditor(this.pBjoern);
		this.pro2rel1spr1fea4.setManDayCosts(new Effort(4));
		this.pro2rel1spr1fea4.setSprint(this.pro2rel1spr1);
		this.pro2rel1spr1fea4.changeState(closedState);

		this.pro2rel1spr1fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 1, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel1spr1fea5.setLastEditor(this.pBjoern);
		this.pro2rel1spr1fea5.setManDayCosts(new Effort(3));
		this.pro2rel1spr1fea5.setSprint(this.pro2rel1spr1);
		this.pro2rel1spr1fea5.changeState(closedState);

		// für Projekt 2, Release 1, Sprint 2
		this.pro2rel1spr2fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 2, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel1spr2fea1.setLastEditor(this.pBjoern);
		this.pro2rel1spr2fea1.setManDayCosts(new Effort(3));
		this.pro2rel1spr2fea1.setSprint(this.pro2rel1spr2);
		// pro2rel1spr2fea1.changeState(closedState);

		this.pro2rel1spr2fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 2, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel1spr2fea2.setLastEditor(this.pBjoern);
		this.pro2rel1spr2fea2.setManDayCosts(new Effort(4));
		this.pro2rel1spr2fea2.setSprint(this.pro2rel1spr2);
		// pro2rel1spr2fea2.changeState(closedState);

		this.pro2rel1spr2fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 2, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel1spr2fea3.setLastEditor(this.pBjoern);
		this.pro2rel1spr2fea3.setManDayCosts(new Effort(5));
		this.pro2rel1spr2fea3.setSprint(this.pro2rel1spr2);
		this.pro2rel1spr2fea3.changeState(closedState);

		this.pro2rel1spr2fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 2, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel1spr2fea4.setLastEditor(this.pBjoern);
		this.pro2rel1spr2fea4.setManDayCosts(new Effort(4));
		this.pro2rel1spr2fea4.setSprint(this.pro2rel1spr2);
		this.pro2rel1spr2fea4.changeState(closedState);

		this.pro2rel1spr2fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 2, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel1spr2fea5.setLastEditor(this.pBjoern);
		this.pro2rel1spr2fea5.setManDayCosts(new Effort(3));
		this.pro2rel1spr2fea5.setSprint(this.pro2rel1spr2);
		this.pro2rel1spr2fea5.changeState(closedState);

		// für Projekt 2, Release 1, Sprint 3
		this.pro2rel1spr3fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 3, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel1spr3fea1.setLastEditor(this.pBjoern);
		this.pro2rel1spr3fea1.setManDayCosts(new Effort(3));
		this.pro2rel1spr3fea1.setSprint(this.pro2rel1spr3);
		// pro2rel1spr3fea1.changeState(closedState);

		this.pro2rel1spr3fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 3, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel1spr3fea2.setLastEditor(this.pBjoern);
		this.pro2rel1spr3fea2.setManDayCosts(new Effort(4));
		this.pro2rel1spr3fea2.setSprint(this.pro2rel1spr3);
		// pro2rel1spr3fea2.changeState(closedState);

		this.pro2rel1spr3fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 3, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel1spr3fea3.setLastEditor(this.pBjoern);
		this.pro2rel1spr3fea3.setManDayCosts(new Effort(5));
		this.pro2rel1spr3fea3.setSprint(this.pro2rel1spr3);
		// pro2rel1spr3fea3.changeState(closedState);

		this.pro2rel1spr3fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 3, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel1spr3fea4.setLastEditor(this.pBjoern);
		this.pro2rel1spr3fea4.setManDayCosts(new Effort(4));
		this.pro2rel1spr3fea4.setSprint(this.pro2rel1spr3);
		this.pro2rel1spr3fea4.changeState(closedState);

		this.pro2rel1spr3fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 3, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel1spr3fea5.setLastEditor(this.pBjoern);
		this.pro2rel1spr3fea5.setManDayCosts(new Effort(3));
		this.pro2rel1spr3fea5.setSprint(this.pro2rel1spr3);
		this.pro2rel1spr3fea5.changeState(closedState);

		// für Projekt 2, Release 1, Sprint 4
		this.pro2rel1spr4fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 4, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel1spr4fea1.setLastEditor(this.pBjoern);
		this.pro2rel1spr4fea1.setManDayCosts(new Effort(3));
		this.pro2rel1spr4fea1.setSprint(this.pro2rel1spr4);
		// pro2rel1spr4fea1.changeState(closedState);

		this.pro2rel1spr4fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 4, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel1spr4fea2.setLastEditor(this.pBjoern);
		this.pro2rel1spr4fea2.setManDayCosts(new Effort(4));
		this.pro2rel1spr4fea2.setSprint(this.pro2rel1spr4);
		// pro2rel1spr4fea2.changeState(closedState);

		this.pro2rel1spr4fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 4, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel1spr4fea3.setLastEditor(this.pBjoern);
		this.pro2rel1spr4fea3.setManDayCosts(new Effort(5));
		this.pro2rel1spr4fea3.setSprint(this.pro2rel1spr4);
		// pro2rel1spr4fea3.changeState(closedState);

		this.pro2rel1spr4fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 4, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel1spr4fea4.setLastEditor(this.pBjoern);
		this.pro2rel1spr4fea4.setManDayCosts(new Effort(4));
		this.pro2rel1spr4fea4.setSprint(this.pro2rel1spr4);
		// pro2rel1spr4fea4.changeState(closedState);

		this.pro2rel1spr4fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 4, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel1spr4fea5.setLastEditor(this.pBjoern);
		this.pro2rel1spr4fea5.setManDayCosts(new Effort(3));
		this.pro2rel1spr4fea5.setSprint(this.pro2rel1spr4);
		this.pro2rel1spr4fea5.changeState(closedState);

		// für Projekt 2, Release 1, Sprint 5
		this.pro2rel1spr5fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 5, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel1spr5fea1.setLastEditor(this.pBjoern);
		this.pro2rel1spr5fea1.setManDayCosts(new Effort(3));
		this.pro2rel1spr5fea1.setSprint(this.pro2rel1spr5);
		// pro2rel1spr5fea1.changeState(closedState);

		this.pro2rel1spr5fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 5, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel1spr5fea2.setLastEditor(this.pBjoern);
		this.pro2rel1spr5fea2.setManDayCosts(new Effort(4));
		this.pro2rel1spr5fea2.setSprint(this.pro2rel1spr5);
		// pro2rel1spr5fea2.changeState(closedState);

		this.pro2rel1spr5fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 5, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel1spr5fea3.setLastEditor(this.pBjoern);
		this.pro2rel1spr5fea3.setManDayCosts(new Effort(5));
		this.pro2rel1spr5fea3.setSprint(this.pro2rel1spr5);
		// pro2rel1spr5fea3.changeState(closedState);

		this.pro2rel1spr5fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 5, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel1spr5fea4.setLastEditor(this.pBjoern);
		this.pro2rel1spr5fea4.setManDayCosts(new Effort(4));
		this.pro2rel1spr5fea4.setSprint(this.pro2rel1spr5);
		// pro2rel1spr5fea4.changeState(closedState);

		this.pro2rel1spr5fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 1, Sprint 5, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel1spr5fea5.setLastEditor(this.pBjoern);
		this.pro2rel1spr5fea5.setManDayCosts(new Effort(3));
		this.pro2rel1spr5fea5.setSprint(this.pro2rel1spr5);
		// pro2rel1spr5fea5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 1
		this.pro2rel2spr1fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 1, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel2spr1fea1.setLastEditor(this.pBjoern);
		this.pro2rel2spr1fea1.setManDayCosts(new Effort(20));
		this.pro2rel2spr1fea1.setSprint(this.pro2rel2spr1);
		this.pro2rel2spr1fea1.changeState(closedState);

		this.pro2rel2spr1fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 1, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel2spr1fea2.setLastEditor(this.pBjoern);
		this.pro2rel2spr1fea2.setManDayCosts(new Effort(41));
		this.pro2rel2spr1fea2.setSprint(this.pro2rel2spr1);
		// pro2rel2spr1fea2.changeState(closedState);

		this.pro2rel2spr1fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 1, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel2spr1fea3.setLastEditor(this.pBjoern);
		this.pro2rel2spr1fea3.setManDayCosts(new Effort(57));
		this.pro2rel2spr1fea3.setSprint(this.pro2rel2spr1);
		// pro2rel2spr1fea3.changeState(closedState);

		this.pro2rel2spr1fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 1, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel2spr1fea4.setLastEditor(this.pBjoern);
		this.pro2rel2spr1fea4.setManDayCosts(new Effort(48));
		this.pro2rel2spr1fea4.setSprint(this.pro2rel2spr1);
		this.pro2rel2spr1fea4.changeState(closedState);

		this.pro2rel2spr1fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 1, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel2spr1fea5.setLastEditor(this.pBjoern);
		this.pro2rel2spr1fea5.setManDayCosts(new Effort(3));
		this.pro2rel2spr1fea5.setSprint(this.pro2rel2spr1);
		this.pro2rel2spr1fea5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 2
		this.pro2rel2spr2fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 2, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel2spr2fea1.setLastEditor(this.pBjoern);
		this.pro2rel2spr2fea1.setManDayCosts(new Effort(3));
		this.pro2rel2spr2fea1.setSprint(this.pro2rel2spr2);
		// pro2rel2spr2fea1.changeState(closedState);

		this.pro2rel2spr2fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 2, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel2spr2fea2.setLastEditor(this.pBjoern);
		this.pro2rel2spr2fea2.setManDayCosts(new Effort(18));
		this.pro2rel2spr2fea2.setSprint(this.pro2rel2spr2);
		this.pro2rel2spr2fea2.changeState(closedState);

		this.pro2rel2spr2fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 2, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel2spr2fea3.setLastEditor(this.pBjoern);
		this.pro2rel2spr2fea3.setManDayCosts(new Effort(5));
		this.pro2rel2spr2fea3.setSprint(this.pro2rel2spr2);
		this.pro2rel2spr2fea3.changeState(closedState);

		this.pro2rel2spr2fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 2, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel2spr2fea4.setLastEditor(this.pBjoern);
		this.pro2rel2spr2fea4.setManDayCosts(new Effort(13));
		this.pro2rel2spr2fea4.setSprint(this.pro2rel2spr2);
		// pro2rel2spr2fea4.changeState(closedState);

		this.pro2rel2spr2fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 2, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel2spr2fea5.setLastEditor(this.pBjoern);
		this.pro2rel2spr2fea5.setManDayCosts(new Effort(8));
		this.pro2rel2spr2fea5.setSprint(this.pro2rel2spr2);
		this.pro2rel2spr2fea5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 3
		this.pro2rel2spr3fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 3, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel2spr3fea1.setLastEditor(this.pBjoern);
		this.pro2rel2spr3fea1.setManDayCosts(new Effort(18));
		this.pro2rel2spr3fea1.setSprint(this.pro2rel2spr3);
		this.pro2rel2spr3fea1.changeState(closedState);

		this.pro2rel2spr3fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 3, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel2spr3fea2.setLastEditor(this.pBjoern);
		this.pro2rel2spr3fea2.setManDayCosts(new Effort(19));
		this.pro2rel2spr3fea2.setSprint(this.pro2rel2spr3);
		this.pro2rel2spr3fea2.changeState(closedState);

		this.pro2rel2spr3fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 3, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel2spr3fea3.setLastEditor(this.pBjoern);
		this.pro2rel2spr3fea3.setManDayCosts(new Effort(15));
		this.pro2rel2spr3fea3.setSprint(this.pro2rel2spr3);
		// pro2rel2spr3fea3.changeState(closedState);

		this.pro2rel2spr3fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 3, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel2spr3fea4.setLastEditor(this.pBjoern);
		this.pro2rel2spr3fea4.setManDayCosts(new Effort(2));
		this.pro2rel2spr3fea4.setSprint(this.pro2rel2spr3);
		// pro2rel2spr3fea4.changeState(closedState);

		this.pro2rel2spr3fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 3, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel2spr3fea5.setLastEditor(this.pBjoern);
		this.pro2rel2spr3fea5.setManDayCosts(new Effort(6));
		this.pro2rel2spr3fea5.setSprint(this.pro2rel2spr3);
		this.pro2rel2spr3fea5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 4
		this.pro2rel2spr4fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 4, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel2spr4fea1.setLastEditor(this.pBjoern);
		this.pro2rel2spr4fea1.setManDayCosts(new Effort(13));
		this.pro2rel2spr4fea1.setSprint(this.pro2rel2spr4);
		this.pro2rel2spr4fea1.changeState(closedState);

		this.pro2rel2spr4fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 4, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel2spr4fea2.setLastEditor(this.pBjoern);
		this.pro2rel2spr4fea2.setManDayCosts(new Effort(15));
		this.pro2rel2spr4fea2.setSprint(this.pro2rel2spr4);
		// pro2rel2spr4fea2.changeState(closedState);

		this.pro2rel2spr4fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 4, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel2spr4fea3.setLastEditor(this.pBjoern);
		this.pro2rel2spr4fea3.setManDayCosts(new Effort(7));
		this.pro2rel2spr4fea3.setSprint(this.pro2rel2spr4);
		this.pro2rel2spr4fea3.changeState(closedState);

		this.pro2rel2spr4fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 4, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel2spr4fea4.setLastEditor(this.pBjoern);
		this.pro2rel2spr4fea4.setManDayCosts(new Effort(4));
		this.pro2rel2spr4fea4.setSprint(this.pro2rel2spr4);
		this.pro2rel2spr4fea4.changeState(closedState);

		this.pro2rel2spr4fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 4, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel2spr4fea5.setLastEditor(this.pBjoern);
		this.pro2rel2spr4fea5.setManDayCosts(new Effort(6));
		this.pro2rel2spr4fea5.setSprint(this.pro2rel2spr4);
		// pro2rel2spr4fea5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 5
		this.pro2rel2spr5fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 5, Feature 1",
						"Beschreibung Feature 1", this.projekt2.getBacklog());
		this.pro2rel2spr5fea1.setLastEditor(this.pBjoern);
		this.pro2rel2spr5fea1.setManDayCosts(new Effort(7));
		this.pro2rel2spr5fea1.setSprint(this.pro2rel2spr5);
		this.pro2rel2spr5fea1.changeState(closedState);

		this.pro2rel2spr5fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 5, Feature 2",
						"Beschreibung Feature 2", this.projekt2.getBacklog());
		this.pro2rel2spr5fea2.setLastEditor(this.pBjoern);
		this.pro2rel2spr5fea2.setManDayCosts(new Effort(8));
		this.pro2rel2spr5fea2.setSprint(this.pro2rel2spr5);
		// pro2rel2spr5fea2.changeState(closedState);

		this.pro2rel2spr5fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 5, Feature 3",
						"Beschreibung Feature 3", this.projekt2.getBacklog());
		this.pro2rel2spr5fea3.setLastEditor(this.pBjoern);
		this.pro2rel2spr5fea3.setManDayCosts(new Effort(5));
		this.pro2rel2spr5fea3.setSprint(this.pro2rel2spr5);
		// pro2rel2spr5fea3.changeState(closedState);

		this.pro2rel2spr5fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 5, Feature 4",
						"Beschreibung Feature 4", this.projekt2.getBacklog());
		this.pro2rel2spr5fea4.setLastEditor(this.pBjoern);
		this.pro2rel2spr5fea4.setManDayCosts(new Effort(2));
		this.pro2rel2spr5fea4.setSprint(this.pro2rel2spr5);
		this.pro2rel2spr5fea4.changeState(closedState);

		this.pro2rel2spr5fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 2, Release 2, Sprint 5, Feature 5",
						"Beschreibung Feature 5", this.projekt2.getBacklog());
		this.pro2rel2spr5fea5.setLastEditor(this.pBjoern);
		this.pro2rel2spr5fea5.setManDayCosts(new Effort(3));
		this.pro2rel2spr5fea5.setSprint(this.pro2rel2spr5);
		this.pro2rel2spr5fea5.changeState(closedState);

		// für Projekt 3, Release 1, Sprint 1
		this.pro3rel1spr1fea1 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 1, Sprint 1, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog(),
						this.pro3rel1);
		this.pro3rel1spr1fea1.setLastEditor(this.pBjoern);
		this.pro3rel1spr1fea1.setManDayCosts(new Effort(3));
		this.pro3rel1spr1fea1.setSprint(this.pro3rel1spr1);
		this.pro3rel1spr1fea1.changeState(closedState);

		this.pro3rel1spr1fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 1, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog());
		this.pro3rel1spr1fea2.setLastEditor(this.pBjoern);
		this.pro3rel1spr1fea2.setManDayCosts(new Effort(4));
		this.pro3rel1spr1fea2.setSprint(this.pro3rel1spr1);
		this.pro3rel1spr1fea2.changeState(closedState);

		this.pro3rel1spr1fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 1, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog());
		this.pro3rel1spr1fea3.setLastEditor(this.pBjoern);
		this.pro3rel1spr1fea3.setManDayCosts(new Effort(5));
		this.pro3rel1spr1fea3.setSprint(this.pro3rel1spr1);
		// pro1rel1spr1fea3.changeState(closedState);

		this.pro3rel1spr1fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 1, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog());
		this.pro3rel1spr1fea4.setLastEditor(this.pBjoern);
		this.pro3rel1spr1fea4.setManDayCosts(new Effort(4));
		this.pro3rel1spr1fea4.setSprint(this.pro3rel1spr1);
		// pro1rel1spr1fea4.changeState(closedState);

		this.pro3rel1spr1fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 1, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog());
		this.pro3rel1spr1fea5.setLastEditor(this.pBjoern);
		this.pro3rel1spr1fea5.setManDayCosts(new Effort(3));
		this.pro3rel1spr1fea5.setSprint(this.pro3rel1spr1);
		this.pro3rel1spr1fea5.changeState(closedState);

		// für Projekt 3, Release 1, Sprint 2
		this.pro3rel1spr2fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 2, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog());
		this.pro3rel1spr2fea1.setLastEditor(this.pBjoern);
		this.pro3rel1spr2fea1.setManDayCosts(new Effort(2));
		this.pro3rel1spr2fea1.setSprint(this.pro3rel1spr2);
		this.pro3rel1spr2fea1.changeState(closedState);

		this.pro3rel1spr2fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 2, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog());
		this.pro3rel1spr2fea2.setLastEditor(this.pBjoern);
		this.pro3rel1spr2fea2.setManDayCosts(new Effort(10));
		this.pro3rel1spr2fea2.setSprint(this.pro3rel1spr2);
		// pro1rel1spr2fea2.changeState(closedState);

		this.pro3rel1spr2fea3 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 1, Sprint 2, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog(),
						this.pro3rel1);
		this.pro3rel1spr2fea3.setLastEditor(this.pBjoern);
		this.pro3rel1spr2fea3.setManDayCosts(new Effort(15));
		this.pro3rel1spr2fea3.setSprint(this.pro3rel1spr2);
		this.pro3rel1spr2fea3.changeState(closedState);

		this.pro3rel1spr2fea4 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 1, Sprint 2, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog(),
						this.pro3rel1);
		this.pro3rel1spr2fea4.setLastEditor(this.pBjoern);
		this.pro3rel1spr2fea4.setManDayCosts(new Effort(3));
		this.pro3rel1spr2fea4.setSprint(this.pro3rel1spr2);
		this.pro3rel1spr2fea4.changeState(closedState);

		this.pro3rel1spr2fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 2, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog());
		this.pro3rel1spr2fea5.setLastEditor(this.pBjoern);
		this.pro3rel1spr2fea5.setManDayCosts(new Effort(6));
		this.pro3rel1spr2fea5.setSprint(this.pro3rel1spr2);
		// pro1rel1spr2fea5.changeState(closedState);

		// für Projekt 3, Release 1, Sprint 3
		this.pro3rel1spr3fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 3, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog());
		this.pro3rel1spr3fea1.setLastEditor(this.pBjoern);
		this.pro3rel1spr3fea1.setManDayCosts(new Effort(20));
		this.pro3rel1spr3fea1.setSprint(this.pro3rel1spr3);
		// pro1rel1spr3fea1.changeState(closedState);

		this.pro3rel1spr3fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 3, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog());
		this.pro3rel1spr3fea2.setLastEditor(this.pBjoern);
		this.pro3rel1spr3fea2.setManDayCosts(new Effort(6));
		this.pro3rel1spr3fea2.setSprint(this.pro3rel1spr3);
		// pro1rel1spr3fea2.changeState(closedState);

		this.pro3rel1spr3fea3 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 1, Sprint 3, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog(),
						this.pro3rel1);
		this.pro3rel1spr3fea3.setLastEditor(this.pBjoern);
		this.pro3rel1spr3fea3.setManDayCosts(new Effort(48));
		this.pro3rel1spr3fea3.setSprint(this.pro3rel1spr3);
		this.pro3rel1spr3fea3.changeState(closedState);

		this.pro3rel1spr3fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 3, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog());
		this.pro3rel1spr3fea4.setLastEditor(this.pBjoern);
		this.pro3rel1spr3fea4.setManDayCosts(new Effort(2));
		this.pro3rel1spr3fea4.setSprint(this.pro3rel1spr3);
		this.pro3rel1spr3fea4.changeState(closedState);

		this.pro3rel1spr3fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 3, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog());
		this.pro3rel1spr3fea5.setLastEditor(this.pBjoern);
		this.pro3rel1spr3fea5.setManDayCosts(new Effort(1));
		this.pro3rel1spr3fea5.setSprint(this.pro3rel1spr3);
		// pro1rel1spr3fea5.changeState(closedState);

		// für Projekt 3, Release 1, Sprint 4
		this.pro3rel1spr4fea1 =
				new Bug(this.model, bugTicketType,
						"Projekt 3 , Release 1, Sprint 4, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog(),
						this.pro3rel1);
		this.pro3rel1spr4fea1.setLastEditor(this.pBjoern);
		this.pro3rel1spr4fea1.setManDayCosts(new Effort(4));
		this.pro3rel1spr4fea1.setSprint(this.pro3rel1spr4);
		// pro1rel1spr4fea1.changeState(closedState);

		this.pro3rel1spr4fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 4, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog());
		this.pro3rel1spr4fea2.setLastEditor(this.pBjoern);
		this.pro3rel1spr4fea2.setManDayCosts(new Effort(10));
		this.pro3rel1spr4fea2.setSprint(this.pro3rel1spr4);
		// pro1rel1spr4fea2.changeState(closedState);

		this.pro3rel1spr4fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 4, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog());
		this.pro3rel1spr4fea3.setLastEditor(this.pBjoern);
		this.pro3rel1spr4fea3.setManDayCosts(new Effort(5));
		this.pro3rel1spr4fea3.setSprint(this.pro3rel1spr4);
		// pro1rel1spr4fea3.changeState(closedState);

		this.pro3rel1spr4fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 4, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog());
		this.pro3rel1spr4fea4.setLastEditor(this.pBjoern);
		this.pro3rel1spr4fea4.setManDayCosts(new Effort(9));
		this.pro3rel1spr4fea4.setSprint(this.pro3rel1spr4);
		// pro1rel1spr4fea4.changeState(closedState);

		this.pro3rel1spr4fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 4, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog());
		this.pro3rel1spr4fea5.setLastEditor(this.pBjoern);
		this.pro3rel1spr4fea5.setManDayCosts(new Effort(3));
		this.pro3rel1spr4fea5.setSprint(this.pro3rel1spr4);
		// pro1rel1spr4fea5.changeState(closedState);

		// für Projekt 3, Release 1, Sprint 5
		this.pro3rel1spr5fea1 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 1, Sprint 5, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog(),
						this.pro3rel1);
		this.pro3rel1spr5fea1.setLastEditor(this.pBjoern);
		this.pro3rel1spr5fea1.setManDayCosts(new Effort(16));
		this.pro3rel1spr5fea1.setSprint(this.pro3rel1spr5);
		this.pro3rel1spr5fea1.changeState(closedState);

		this.pro3rel1spr5fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 5, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog());
		this.pro3rel1spr5fea2.setLastEditor(this.pBjoern);
		this.pro3rel1spr5fea2.setManDayCosts(new Effort(4));
		this.pro3rel1spr5fea2.setSprint(this.pro3rel1spr5);
		this.pro3rel1spr5fea2.changeState(closedState);

		this.pro3rel1spr5fea3 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 1, Sprint 5, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog(),
						this.pro3rel1);
		this.pro3rel1spr5fea3.setLastEditor(this.pBjoern);
		this.pro3rel1spr5fea3.setManDayCosts(new Effort(5));
		this.pro3rel1spr5fea3.setSprint(this.pro3rel1spr5);
		this.pro3rel1spr5fea3.changeState(closedState);

		this.pro3rel1spr5fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 1, Sprint 5, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog());
		this.pro3rel1spr5fea4.setLastEditor(this.pBjoern);
		this.pro3rel1spr5fea4.setManDayCosts(new Effort(35));
		this.pro3rel1spr5fea4.setSprint(this.pro3rel1spr5);
		this.pro3rel1spr5fea4.changeState(closedState);

		this.pro3rel1spr5fea5 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 1, Sprint 5, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog(),
						this.pro3rel1);
		this.pro3rel1spr5fea5.setLastEditor(this.pBjoern);
		this.pro3rel1spr5fea5.setManDayCosts(new Effort(3));
		this.pro3rel1spr5fea5.setSprint(this.pro3rel1spr5);
		this.pro3rel1spr5fea5.changeState(closedState);

		// für Projekt 3, Release 2, Sprint 1
		this.pro3rel2spr1fea1 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 1, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr1fea1.setLastEditor(this.pBjoern);
		this.pro3rel2spr1fea1.setManDayCosts(new Effort(80));
		this.pro3rel2spr1fea1.setSprint(this.pro3rel2spr1);
		this.pro3rel2spr1fea1.changeState(closedState);

		this.pro3rel2spr1fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 1, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog());
		this.pro3rel2spr1fea2.setLastEditor(this.pBjoern);
		this.pro3rel2spr1fea2.setManDayCosts(new Effort(20));
		this.pro3rel2spr1fea2.setSprint(this.pro3rel2spr1);
		// pro1rel2spr1fea2.changeState(closedState);

		this.pro3rel2spr1fea3 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 1, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr1fea3.setLastEditor(this.pBjoern);
		this.pro3rel2spr1fea3.setManDayCosts(new Effort(5));
		this.pro3rel2spr1fea3.setSprint(this.pro3rel2spr1);
		this.pro3rel2spr1fea3.changeState(closedState);

		this.pro3rel2spr1fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 1, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog());
		this.pro3rel2spr1fea4.setLastEditor(this.pBjoern);
		this.pro3rel2spr1fea4.setManDayCosts(new Effort(4));
		this.pro3rel2spr1fea4.setSprint(this.pro3rel2spr1);
		this.pro3rel2spr1fea4.changeState(closedState);

		this.pro3rel2spr1fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 1, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog());
		this.pro3rel2spr1fea5.setLastEditor(this.pBjoern);
		this.pro3rel2spr1fea5.setManDayCosts(new Effort(3));
		this.pro3rel2spr1fea5.setSprint(this.pro3rel2spr1);
		this.pro3rel2spr1fea5.changeState(closedState);

		// für Projekt 3, Release 2, Sprint 2
		this.pro3rel2spr2fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 2, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog());
		this.pro3rel2spr2fea1.setLastEditor(this.pBjoern);
		this.pro3rel2spr2fea1.setManDayCosts(new Effort(5));
		this.pro3rel2spr2fea1.setSprint(this.pro3rel2spr2);
		// pro1rel2spr2fea1.changeState(closedState);

		this.pro3rel2spr2fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 2, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog());
		this.pro3rel2spr2fea2.setLastEditor(this.pBjoern);
		this.pro3rel2spr2fea2.setManDayCosts(new Effort(20));
		this.pro3rel2spr2fea2.setSprint(this.pro3rel2spr2);
		// pro1rel2spr2fea2.changeState(closedState);

		this.pro3rel2spr2fea3 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 2, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr2fea3.setLastEditor(this.pBjoern);
		this.pro3rel2spr2fea3.setManDayCosts(new Effort(5));
		this.pro3rel2spr2fea3.setSprint(this.pro3rel2spr2);
		// pro1rel2spr2fea3.changeState(closedState);

		this.pro3rel2spr2fea4 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 2, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr2fea4.setLastEditor(this.pBjoern);
		this.pro3rel2spr2fea4.setManDayCosts(new Effort(6));
		this.pro3rel2spr2fea4.setSprint(this.pro3rel2spr2);
		this.pro3rel2spr2fea4.changeState(closedState);

		this.pro3rel2spr2fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 2, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog());
		this.pro3rel2spr2fea5.setLastEditor(this.pBjoern);
		this.pro3rel2spr2fea5.setManDayCosts(new Effort(35));
		this.pro3rel2spr2fea5.setSprint(this.pro3rel2spr2);
		this.pro3rel2spr2fea5.changeState(closedState);

		// für Projekt 3, Release 2, Sprint 3
		this.pro3rel2spr3fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 3, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog());
		this.pro3rel2spr3fea1.setLastEditor(this.pBjoern);
		this.pro3rel2spr3fea1.setManDayCosts(new Effort(13));
		this.pro3rel2spr3fea1.setSprint(this.pro3rel2spr3);
		this.pro3rel2spr3fea1.changeState(closedState);

		this.pro3rel2spr3fea2 =
				new Bug(this.model, bugTicketType,
						"Projekt 1, Release 2, Sprint 3, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr3fea2.setLastEditor(this.pBjoern);
		this.pro3rel2spr3fea2.setManDayCosts(new Effort(7));
		this.pro3rel2spr3fea2.setSprint(this.pro3rel2spr3);
		this.pro3rel2spr3fea2.changeState(closedState);

		this.pro3rel2spr3fea3 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 3, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog());
		this.pro3rel2spr3fea3.setLastEditor(this.pBjoern);
		this.pro3rel2spr3fea3.setManDayCosts(new Effort(100));
		this.pro3rel2spr3fea3.setSprint(this.pro3rel2spr3);
		// pro1rel2spr3fea3.changeState(closedState);

		this.pro3rel2spr3fea4 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 3, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog());
		this.pro3rel2spr3fea4.setLastEditor(this.pBjoern);
		this.pro3rel2spr3fea4.setManDayCosts(new Effort(83));
		this.pro3rel2spr3fea4.setSprint(this.pro3rel2spr3);
		this.pro3rel2spr3fea4.changeState(closedState);

		this.pro3rel2spr3fea5 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 3, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr3fea5.setLastEditor(this.pBjoern);
		this.pro3rel2spr3fea5.setManDayCosts(new Effort(3));
		this.pro3rel2spr3fea5.setSprint(this.pro3rel2spr3);
		// pro1rel2spr3fea5.changeState(closedState);

		// für Projekt 3, Release 2, Sprint 4
		this.pro3rel2spr4fea1 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 4, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog());
		this.pro3rel2spr4fea1.setLastEditor(this.pBjoern);
		this.pro3rel2spr4fea1.setManDayCosts(new Effort(20));
		this.pro3rel2spr4fea1.setSprint(this.pro3rel2spr4);
		this.pro3rel2spr4fea1.changeState(closedState);

		this.pro3rel2spr4fea2 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 4, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog());
		this.pro3rel2spr4fea2.setLastEditor(this.pBjoern);
		this.pro3rel2spr4fea2.setManDayCosts(new Effort(14));
		this.pro3rel2spr4fea2.setSprint(this.pro3rel2spr4);
		// pro1rel2spr4fea2.changeState(closedState);

		this.pro3rel2spr4fea3 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 4, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr4fea3.setLastEditor(this.pBjoern);
		this.pro3rel2spr4fea3.setManDayCosts(new Effort(80));
		this.pro3rel2spr4fea3.setSprint(this.pro3rel2spr4);
		this.pro3rel2spr4fea3.changeState(closedState);

		this.pro3rel2spr4fea4 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 4, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr4fea4.setLastEditor(this.pBjoern);
		this.pro3rel2spr4fea4.setManDayCosts(new Effort(12));
		this.pro3rel2spr4fea4.setSprint(this.pro3rel2spr4);
		// pro1rel2spr4fea4.changeState(closedState);

		this.pro3rel2spr4fea5 =
				new Feature(this.model, featureTicketType,
						"Projekt 3, Release 2, Sprint 4, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog());
		this.pro3rel2spr4fea5.setLastEditor(this.pBjoern);
		this.pro3rel2spr4fea5.setManDayCosts(new Effort(16));
		this.pro3rel2spr4fea5.setSprint(this.pro3rel2spr4);
		this.pro3rel2spr4fea5.changeState(closedState);

		// für Projekt 3, Release 2, Sprint 5
		this.pro3rel2spr5fea1 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 5, Feature 1",
						"Beschreibung Feature 1", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr5fea1.setLastEditor(this.pBjoern);
		this.pro3rel2spr5fea1.setManDayCosts(new Effort(13));
		this.pro3rel2spr5fea1.setSprint(this.pro3rel2spr5);
		// pro1rel2spr5fea1.changeState(closedState);

		this.pro3rel2spr5fea2 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 5, Feature 2",
						"Beschreibung Feature 2", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr5fea2.setLastEditor(this.pBjoern);
		this.pro3rel2spr5fea2.setManDayCosts(new Effort(14));
		this.pro3rel2spr5fea2.setSprint(this.pro3rel2spr5);
		this.pro3rel2spr5fea2.changeState(closedState);

		this.pro3rel2spr5fea3 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 5, Feature 3",
						"Beschreibung Feature 3", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr5fea3.setLastEditor(this.pBjoern);
		this.pro3rel2spr5fea3.setManDayCosts(new Effort(5));
		this.pro3rel2spr5fea3.setSprint(this.pro3rel2spr5);
		this.pro3rel2spr5fea3.changeState(closedState);

		this.pro3rel2spr5fea4 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 5, Feature 4",
						"Beschreibung Feature 4", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr5fea4.setLastEditor(this.pBjoern);
		this.pro3rel2spr5fea4.setManDayCosts(new Effort(4));
		this.pro3rel2spr5fea4.setSprint(this.pro3rel2spr5);
		// pro1rel2spr5fea4.changeState(closedState);

		this.pro3rel2spr5fea5 =
				new Bug(this.model, bugTicketType,
						"Projekt 3, Release 2, Sprint 5, Feature 5",
						"Beschreibung Feature 5", this.projekt3.getBacklog(),
						this.pro3rel2);
		this.pro3rel2spr5fea5.setLastEditor(this.pBjoern);
		this.pro3rel2spr5fea5.setManDayCosts(new Effort(3));
		this.pro3rel2spr5fea5.setSprint(this.pro3rel2spr5);
		this.pro3rel2spr5fea5.changeState(closedState);

		// Initial Tasks
		// für Projekt 1, Release 1, Sprint 1
		final TaskTicketType taskTicketType =
				this.model.getTypeManager().getStandardTaskType();
		this.pro1rel1spr1tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 1, Task 1",
						"Beschreibung von Task 1", this.pro1rel1spr1.getSprintBacklog());
		this.pro1rel1spr1.getSprintBacklog().addTask(this.pro1rel1spr1tas1);
		this.pro1rel1spr1tas1.addPBI(this.pro1rel1spr1fea1);
		this.pro1rel1spr1tas1.setPlanEffort(new Effort(1));
		this.pro1rel1spr1tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr1tas1.setResponsibility(this.pBjoern);
		this.pro1rel1spr1tas1.setFinishDate(new Date(2011 - 1900, 2 - 1, 3));
		this.pro1rel1spr1tas1.changeState(closedState);

		this.pro1rel1spr1tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 1, Task 2",
						"Beschreibung von Task 2", this.pro1rel1spr1.getSprintBacklog());
		this.pro1rel1spr1.getSprintBacklog().addTask(this.pro1rel1spr1tas2);
		this.pro1rel1spr1tas2.addPBI(this.pro1rel1spr1fea2);
		this.pro1rel1spr1tas2.setPlanEffort(new Effort(2));
		this.pro1rel1spr1tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr1tas2.setResponsibility(this.pBjoern);
		this.pro1rel1spr1tas2.setFinishDate(new Date(2011 - 1900, 2 - 1, 3));
		this.pro1rel1spr1tas2.changeState(closedState);

		this.pro1rel1spr1tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 1, Task 3",
						"Beschreibung von Task 3", this.pro1rel1spr1.getSprintBacklog());
		this.pro1rel1spr1.getSprintBacklog().addTask(this.pro1rel1spr1tas3);
		this.pro1rel1spr1tas3.addPBI(this.pro1rel1spr1fea3);
		this.pro1rel1spr1tas3.setPlanEffort(new Effort(3));
		this.pro1rel1spr1tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr1tas3.setResponsibility(this.pBjoern);
		this.pro1rel1spr1tas3.setFinishDate(new Date(2011 - 1900, 2 - 1, 1, 12, 0));
		this.pro1rel1spr1tas3.changeState(closedState);

		this.pro1rel1spr1tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 1, Task 4",
						"Beschreibung von Task 4", this.pro1rel1spr1.getSprintBacklog());
		this.pro1rel1spr1.getSprintBacklog().addTask(this.pro1rel1spr1tas4);
		this.pro1rel1spr1tas4.addPBI(this.pro1rel1spr1fea4);
		this.pro1rel1spr1tas4.setPlanEffort(new Effort(4));
		this.pro1rel1spr1tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr1tas4.setResponsibility(this.pBjoern);
		this.pro1rel1spr1tas4.setFinishDate(new Date(2011 - 1900, 2 - 1, 2, 12, 0));
		this.pro1rel1spr1tas4.changeState(closedState);

		this.pro1rel1spr1tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 1, Task 5",
						"Beschreibung von Task 5", this.pro1rel1spr1.getSprintBacklog());
		this.pro1rel1spr1.getSprintBacklog().addTask(this.pro1rel1spr1tas5);
		this.pro1rel1spr1tas5.addPBI(this.pro1rel1spr1fea5);
		this.pro1rel1spr1tas5.setPlanEffort(new Effort(5));
		this.pro1rel1spr1tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr1tas5.setResponsibility(this.pBjoern);
		this.pro1rel1spr1tas5.setFinishDate(new Date(2011 - 1900, 2 - 1, 4, 12, 0));
		this.pro1rel1spr1tas5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 2
		this.pro1rel1spr2tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 2, Task 1",
						"Beschreibung von Task 1", this.pro1rel1spr2.getSprintBacklog());
		this.pro1rel1spr2.getSprintBacklog().addTask(this.pro1rel1spr2tas1);
		this.pro1rel1spr2tas1.addPBI(this.pro1rel1spr2fea1);
		this.pro1rel1spr2tas1.setPlanEffort(new Effort(6));
		this.pro1rel1spr2tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr2tas1.setResponsibility(this.pBjoern);
		this.pro1rel1spr2tas1.setFinishDate(new Date(2011 - 1900, 3 - 1, 13, 12, 0));
		this.pro1rel1spr2tas1.changeState(closedState);

		this.pro1rel1spr2tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 2, Task 2",
						"Beschreibung von Task 2", this.pro1rel1spr2.getSprintBacklog());
		this.pro1rel1spr2.getSprintBacklog().addTask(this.pro1rel1spr2tas2);
		this.pro1rel1spr2tas2.addPBI(this.pro1rel1spr2fea2);
		this.pro1rel1spr2tas2.setPlanEffort(new Effort(7));
		this.pro1rel1spr2tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr2tas2.setResponsibility(this.pBjoern);
		this.pro1rel1spr2tas2.setFinishDate(new Date(2011 - 1900, 3 - 1, 14, 12, 0));
		this.pro1rel1spr2tas2.changeState(closedState);

		this.pro1rel1spr2tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 2, Task 3",
						"Beschreibung von Task 3", this.pro1rel1spr2.getSprintBacklog());
		this.pro1rel1spr2.getSprintBacklog().addTask(this.pro1rel1spr2tas3);
		this.pro1rel1spr2tas3.addPBI(this.pro1rel1spr2fea3);
		this.pro1rel1spr2tas3.setPlanEffort(new Effort(8));
		this.pro1rel1spr2tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr2tas3.setResponsibility(this.pBjoern);
		this.pro1rel1spr2tas3.setFinishDate(new Date(2011 - 1900, 3 - 1, 14, 12, 0));
		this.pro1rel1spr2tas3.changeState(closedState);

		this.pro1rel1spr2tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 2, Task 4",
						"Beschreibung von Task 4", this.pro1rel1spr2.getSprintBacklog());
		this.pro1rel1spr2.getSprintBacklog().addTask(this.pro1rel1spr2tas4);
		this.pro1rel1spr2tas4.addPBI(this.pro1rel1spr2fea4);
		this.pro1rel1spr2tas4.setPlanEffort(new Effort(1));
		this.pro1rel1spr2tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr2tas4.setResponsibility(this.pBjoern);
		this.pro1rel1spr2tas4.setFinishDate(new Date(2011 - 1900, 3 - 1, 13, 12, 0));
		this.pro1rel1spr2tas4.changeState(closedState);

		this.pro1rel1spr2tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 2, Task 5",
						"Beschreibung von Task 5", this.pro1rel1spr2.getSprintBacklog());
		this.pro1rel1spr2.getSprintBacklog().addTask(this.pro1rel1spr2tas5);
		this.pro1rel1spr2tas5.addPBI(this.pro1rel1spr2fea5);
		this.pro1rel1spr2tas5.setPlanEffort(new Effort(2));
		this.pro1rel1spr2tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr2tas5.setResponsibility(this.pBjoern);
		this.pro1rel1spr2tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 12, 12, 0));
		this.pro1rel1spr2tas5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 3
		this.pro1rel1spr3tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 3, Task 1",
						"Beschreibung von Task 1", this.pro1rel1spr3.getSprintBacklog());
		this.pro1rel1spr3.getSprintBacklog().addTask(this.pro1rel1spr3tas1);
		this.pro1rel1spr3tas1.addPBI(this.pro1rel1spr3fea1);
		this.pro1rel1spr3tas1.setPlanEffort(new Effort(7));
		this.pro1rel1spr3tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr3tas1.setResponsibility(this.pBjoern);
		this.pro1rel1spr3tas1.setFinishDate(new Date(2011 - 1900, 1 - 1, 4, 12, 0));
		this.pro1rel1spr3tas1.changeState(closedState);

		this.pro1rel1spr3tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 3, Task 2",
						"Beschreibung von Task 2", this.pro1rel1spr3.getSprintBacklog());
		this.pro1rel1spr3.getSprintBacklog().addTask(this.pro1rel1spr3tas2);
		this.pro1rel1spr3tas2.addPBI(this.pro1rel1spr3fea2);
		this.pro1rel1spr3tas2.setPlanEffort(new Effort(7));
		this.pro1rel1spr3tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr3tas2.setResponsibility(this.pBjoern);
		this.pro1rel1spr3tas2.setFinishDate(new Date(2011 - 1900, 1 - 1, 4, 12, 0));
		this.pro1rel1spr3tas2.changeState(closedState);

		this.pro1rel1spr3tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 3, Task 3",
						"Beschreibung von Task 3", this.pro1rel1spr3.getSprintBacklog());
		this.pro1rel1spr3.getSprintBacklog().addTask(this.pro1rel1spr3tas3);
		this.pro1rel1spr3tas3.addPBI(this.pro1rel1spr3fea3);
		this.pro1rel1spr3tas3.setPlanEffort(new Effort(7));
		this.pro1rel1spr3tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr3tas3.setResponsibility(this.pBjoern);
		this.pro1rel1spr3tas3.setFinishDate(new Date(2011 - 1900, 1 - 1, 3, 12, 0));
		this.pro1rel1spr3tas3.changeState(closedState);

		this.pro1rel1spr3tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 3, Task 4",
						"Beschreibung von Task 4", this.pro1rel1spr3.getSprintBacklog());
		this.pro1rel1spr3.getSprintBacklog().addTask(this.pro1rel1spr3tas4);
		this.pro1rel1spr3tas4.addPBI(this.pro1rel1spr3fea4);
		this.pro1rel1spr3tas4.setPlanEffort(new Effort(7));
		this.pro1rel1spr3tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr3tas4.setResponsibility(this.pBjoern);
		this.pro1rel1spr3tas4.setFinishDate(new Date(2011 - 1900, 1 - 1, 3, 12, 0));
		this.pro1rel1spr3tas4.changeState(closedState);

		this.pro1rel1spr3tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 3, Task 5",
						"Beschreibung von Task 5", this.pro1rel1spr3.getSprintBacklog());
		this.pro1rel1spr3.getSprintBacklog().addTask(this.pro1rel1spr3tas5);
		this.pro1rel1spr3tas5.addPBI(this.pro1rel1spr3fea5);
		this.pro1rel1spr3tas5.setPlanEffort(new Effort(7));
		this.pro1rel1spr3tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr3tas5.setResponsibility(this.pBjoern);
		this.pro1rel1spr3tas5.setFinishDate(new Date(2011 - 1900, 1 - 1, 4, 12, 0));
		this.pro1rel1spr3tas5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 4
		this.pro1rel1spr4tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 4, Task 1",
						"Beschreibung von Task 1", this.pro1rel1spr4.getSprintBacklog());
		this.pro1rel1spr4.getSprintBacklog().addTask(this.pro1rel1spr4tas1);
		this.pro1rel1spr4tas1.addPBI(this.pro1rel1spr4fea1);
		this.pro1rel1spr4tas1.setPlanEffort(new Effort(2));
		this.pro1rel1spr4tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr4tas1.setResponsibility(this.pBjoern);
		this.pro1rel1spr4tas1.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro1rel1spr4tas1.changeState(closedState);

		this.pro1rel1spr4tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 4, Task 2",
						"Beschreibung von Task 2", this.pro1rel1spr4.getSprintBacklog());
		this.pro1rel1spr4.getSprintBacklog().addTask(this.pro1rel1spr4tas2);
		this.pro1rel1spr4tas2.addPBI(this.pro1rel1spr4fea2);
		this.pro1rel1spr4tas2.setPlanEffort(new Effort(2));
		this.pro1rel1spr4tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr4tas2.setResponsibility(this.pBjoern);
		this.pro1rel1spr4tas2.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro1rel1spr4tas2.changeState(closedState);

		this.pro1rel1spr4tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 4, Task 3",
						"Beschreibung von Task 3", this.pro1rel1spr4.getSprintBacklog());
		this.pro1rel1spr4.getSprintBacklog().addTask(this.pro1rel1spr4tas3);
		this.pro1rel1spr4tas3.addPBI(this.pro1rel1spr4fea3);
		this.pro1rel1spr4tas3.setPlanEffort(new Effort(2));
		this.pro1rel1spr4tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr4tas3.setResponsibility(this.pBjoern);
		this.pro1rel1spr4tas3.setFinishDate(new Date(2011 - 1900, 2 - 1, 28, 12, 0));
		this.pro1rel1spr4tas3.changeState(closedState);

		this.pro1rel1spr4tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 4, Task 4",
						"Beschreibung von Task 4", this.pro1rel1spr4.getSprintBacklog());
		this.pro1rel1spr4.getSprintBacklog().addTask(this.pro1rel1spr4tas4);
		this.pro1rel1spr4tas4.addPBI(this.pro1rel1spr4fea4);
		this.pro1rel1spr4tas4.setPlanEffort(new Effort(3));
		this.pro1rel1spr4tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr4tas4.setResponsibility(this.pBjoern);
		this.pro1rel1spr4tas4.setFinishDate(new Date(2011 - 1900, 2 - 1, 28, 12, 0));
		this.pro1rel1spr4tas4.changeState(closedState);

		this.pro1rel1spr4tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 4, Task 5",
						"Beschreibung von Task 5", this.pro1rel1spr4.getSprintBacklog());
		this.pro1rel1spr4.getSprintBacklog().addTask(this.pro1rel1spr4tas5);
		this.pro1rel1spr4tas5.addPBI(this.pro1rel1spr4fea5);
		this.pro1rel1spr4tas5.setPlanEffort(new Effort(8));
		this.pro1rel1spr4tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr4tas5.setResponsibility(this.pBjoern);
		this.pro1rel1spr4tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.pro1rel1spr4tas5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 5
		this.pro1rel1spr5tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 5, Task 1",
						"Beschreibung von Task 1", this.pro1rel1spr5.getSprintBacklog());
		this.pro1rel1spr5.getSprintBacklog().addTask(this.pro1rel1spr5tas1);
		this.pro1rel1spr5tas1.addPBI(this.pro1rel1spr5fea1);
		this.pro1rel1spr5tas1.setPlanEffort(new Effort(5));
		this.pro1rel1spr5tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr5tas1.setResponsibility(this.pBjoern);
		this.pro1rel1spr5tas1.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro1rel1spr5tas1.changeState(closedState);

		this.pro1rel1spr5tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 5, Task 2",
						"Beschreibung von Task 2", this.pro1rel1spr5.getSprintBacklog());
		this.pro1rel1spr5.getSprintBacklog().addTask(this.pro1rel1spr5tas2);
		this.pro1rel1spr5tas2.addPBI(this.pro1rel1spr5fea2);
		this.pro1rel1spr5tas2.setPlanEffort(new Effort(3));
		this.pro1rel1spr5tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr5tas2.setResponsibility(this.pBjoern);
		this.pro1rel1spr5tas2.setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.pro1rel1spr5tas2.changeState(closedState);

		this.pro1rel1spr5tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 5, Task 3",
						"Beschreibung von Task 3", this.pro1rel1spr5.getSprintBacklog());
		this.pro1rel1spr5.getSprintBacklog().addTask(this.pro1rel1spr5tas3);
		this.pro1rel1spr5tas3.addPBI(this.pro1rel1spr5fea3);
		this.pro1rel1spr5tas3.setPlanEffort(new Effort(4));
		this.pro1rel1spr5tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr5tas3.setResponsibility(this.pBjoern);
		this.pro1rel1spr5tas3.setFinishDate(new Date(2011 - 1900, 3 - 1, 3, 12, 0));
		this.pro1rel1spr5tas3.changeState(closedState);

		this.pro1rel1spr5tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 5, Task 4",
						"Beschreibung von Task 4", this.pro1rel1spr5.getSprintBacklog());
		this.pro1rel1spr5.getSprintBacklog().addTask(this.pro1rel1spr5tas4);
		this.pro1rel1spr5tas4.addPBI(this.pro1rel1spr5fea4);
		this.pro1rel1spr5tas4.setPlanEffort(new Effort(7));
		this.pro1rel1spr5tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr5tas4.setResponsibility(this.pBjoern);
		this.pro1rel1spr5tas4.setFinishDate(new Date(2011 - 1900, 3 - 1, 4, 12, 0));
		this.pro1rel1spr5tas4.changeState(closedState);

		this.pro1rel1spr5tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 1, Sprint 5, Task 5",
						"Beschreibung von Task 5", this.pro1rel1spr5.getSprintBacklog());
		this.pro1rel1spr5.getSprintBacklog().addTask(this.pro1rel1spr5tas5);
		this.pro1rel1spr5tas5.addPBI(this.pro1rel1spr5fea5);
		this.pro1rel1spr5tas5.setPlanEffort(new Effort(2));
		this.pro1rel1spr5tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel1spr5tas5.setResponsibility(this.pBjoern);
		this.pro1rel1spr5tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 10, 12, 0));
		this.pro1rel1spr5tas5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 1
		this.pro1rel2spr1tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 1, Task 1",
						"Beschreibung von Task 1", this.pro1rel2spr1.getSprintBacklog());
		this.pro1rel2spr1.getSprintBacklog().addTask(this.pro1rel2spr1tas1);
		this.pro1rel2spr1tas1.addPBI(this.pro1rel2spr1fea1);
		this.pro1rel2spr1tas1.setPlanEffort(new Effort(8));
		this.pro1rel2spr1tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr1tas1.setResponsibility(this.pBjoern);
		// pro1rel2spr1tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr1tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 1, Task 2",
						"Beschreibung von Task 2", this.pro1rel2spr1.getSprintBacklog());
		this.pro1rel2spr1.getSprintBacklog().addTask(this.pro1rel2spr1tas2);
		this.pro1rel2spr1tas2.addPBI(this.pro1rel2spr1fea2);
		this.pro1rel2spr1tas2.setPlanEffort(new Effort(6));
		this.pro1rel2spr1tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr1tas2.setResponsibility(this.pBjoern);
		// pro1rel2spr1tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr1tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 1, Task 3",
						"Beschreibung von Task 3", this.pro1rel2spr1.getSprintBacklog());
		this.pro1rel2spr1.getSprintBacklog().addTask(this.pro1rel2spr1tas3);
		this.pro1rel2spr1tas3.addPBI(this.pro1rel2spr1fea3);
		this.pro1rel2spr1tas3.setPlanEffort(new Effort(4));
		this.pro1rel2spr1tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr1tas3.setResponsibility(this.pBjoern);
		// pro1rel2spr1tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr1tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 1, Task 4",
						"Beschreibung von Task 4", this.pro1rel2spr1.getSprintBacklog());
		this.pro1rel2spr1.getSprintBacklog().addTask(this.pro1rel2spr1tas4);
		this.pro1rel2spr1tas4.addPBI(this.pro1rel2spr1fea4);
		this.pro1rel2spr1tas4.setPlanEffort(new Effort(6));
		this.pro1rel2spr1tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr1tas4.setResponsibility(this.pBjoern);
		// pro1rel2spr1tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr1tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 1, Task 5",
						"Beschreibung von Task 5", this.pro1rel2spr1.getSprintBacklog());
		this.pro1rel2spr1.getSprintBacklog().addTask(this.pro1rel2spr1tas5);
		this.pro1rel2spr1tas5.addPBI(this.pro1rel2spr1fea5);
		this.pro1rel2spr1tas5.setPlanEffort(new Effort(8));
		this.pro1rel2spr1tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr1tas5.setResponsibility(this.pBjoern);
		this.pro1rel2spr1tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro1rel2spr1tas5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 2
		this.pro1rel2spr2tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 2, Task 1",
						"Beschreibung von Task 1", this.pro1rel2spr2.getSprintBacklog());
		this.pro1rel2spr2.getSprintBacklog().addTask(this.pro1rel2spr2tas1);
		this.pro1rel2spr2tas1.addPBI(this.pro1rel2spr2fea1);
		this.pro1rel2spr2tas1.setPlanEffort(new Effort(7));
		this.pro1rel2spr2tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr2tas1.setResponsibility(this.pBjoern);
		// pro1rel2spr2tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr2tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 2, Task 2",
						"Beschreibung von Task 2", this.pro1rel2spr2.getSprintBacklog());
		this.pro1rel2spr2.getSprintBacklog().addTask(this.pro1rel2spr2tas2);
		this.pro1rel2spr2tas2.addPBI(this.pro1rel2spr2fea2);
		this.pro1rel2spr2tas2.setPlanEffort(new Effort(8));
		this.pro1rel2spr2tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr2tas2.setResponsibility(this.pBjoern);
		// pro1rel2spr2tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr2tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 2, Task 3",
						"Beschreibung von Task 3", this.pro1rel2spr2.getSprintBacklog());
		this.pro1rel2spr2.getSprintBacklog().addTask(this.pro1rel2spr2tas3);
		this.pro1rel2spr2tas3.addPBI(this.pro1rel2spr2fea3);
		this.pro1rel2spr2tas3.setPlanEffort(new Effort(2));
		this.pro1rel2spr2tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr2tas3.setResponsibility(this.pBjoern);
		// pro1rel2spr2tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr2tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 2, Task 4",
						"Beschreibung von Task 4", this.pro1rel2spr2.getSprintBacklog());
		this.pro1rel2spr2.getSprintBacklog().addTask(this.pro1rel2spr2tas4);
		this.pro1rel2spr2tas4.addPBI(this.pro1rel2spr2fea4);
		this.pro1rel2spr2tas4.setPlanEffort(new Effort(3));
		this.pro1rel2spr2tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr2tas4.setResponsibility(this.pBjoern);
		this.pro1rel2spr2tas4.setFinishDate(new Date(2011 - 1900, 3 - 1, 5, 12, 0));
		this.pro1rel2spr2tas4.changeState(closedState);

		this.pro1rel2spr2tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 2, Task 5",
						"Beschreibung von Task 5", this.pro1rel2spr2.getSprintBacklog());
		this.pro1rel2spr2.getSprintBacklog().addTask(this.pro1rel2spr2tas5);
		this.pro1rel2spr2tas5.addPBI(this.pro1rel2spr2fea5);
		this.pro1rel2spr2tas5.setPlanEffort(new Effort(3));
		this.pro1rel2spr2tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr2tas5.setResponsibility(this.pBjoern);
		this.pro1rel2spr2tas5.setFinishDate(new Date(2011 - 1900, 2 - 1, 1, 12, 0));
		this.pro1rel2spr2tas5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 3
		this.pro1rel2spr3tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 3, Task 1",
						"Beschreibung von Task 1", this.pro1rel2spr3.getSprintBacklog());
		this.pro1rel2spr3.getSprintBacklog().addTask(this.pro1rel2spr3tas1);
		this.pro1rel2spr3tas1.addPBI(this.pro1rel2spr3fea1);
		this.pro1rel2spr3tas1.setPlanEffort(new Effort(5));
		this.pro1rel2spr3tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr3tas1.setResponsibility(this.pBjoern);
		// pro1rel2spr3tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr3tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 3, Task 2",
						"Beschreibung von Task 2", this.pro1rel2spr3.getSprintBacklog());
		this.pro1rel2spr3.getSprintBacklog().addTask(this.pro1rel2spr3tas2);
		this.pro1rel2spr3tas2.addPBI(this.pro1rel2spr3fea2);
		this.pro1rel2spr3tas2.setPlanEffort(new Effort(5));
		this.pro1rel2spr3tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr3tas2.setResponsibility(this.pBjoern);
		// pro1rel2spr3tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr3tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 3, Task 3",
						"Beschreibung von Task 3", this.pro1rel2spr3.getSprintBacklog());
		this.pro1rel2spr3.getSprintBacklog().addTask(this.pro1rel2spr3tas3);
		this.pro1rel2spr3tas3.addPBI(this.pro1rel2spr3fea3);
		this.pro1rel2spr3tas3.setPlanEffort(new Effort(8));
		this.pro1rel2spr3tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr3tas3.setResponsibility(this.pBjoern);
		this.pro1rel2spr3tas3.setFinishDate(new Date(2011 - 1900, 3 - 1, 19, 12, 0));
		this.pro1rel2spr3tas3.changeState(closedState);

		this.pro1rel2spr3tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 3, Task 4",
						"Beschreibung von Task 4", this.pro1rel2spr3.getSprintBacklog());
		this.pro1rel2spr3.getSprintBacklog().addTask(this.pro1rel2spr3tas4);
		this.pro1rel2spr3tas4.addPBI(this.pro1rel2spr3fea4);
		this.pro1rel2spr3tas4.setPlanEffort(new Effort(8));
		this.pro1rel2spr3tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr3tas4.setResponsibility(this.pBjoern);
		this.pro1rel2spr3tas4.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro1rel2spr3tas4.changeState(closedState);

		this.pro1rel2spr3tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 3, Task 5",
						"Beschreibung von Task 5", this.pro1rel2spr3.getSprintBacklog());
		this.pro1rel2spr3.getSprintBacklog().addTask(this.pro1rel2spr3tas5);
		this.pro1rel2spr3tas5.addPBI(this.pro1rel2spr3fea5);
		this.pro1rel2spr3tas5.setPlanEffort(new Effort(9));
		this.pro1rel2spr3tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr3tas5.setResponsibility(this.pBjoern);
		this.pro1rel2spr3tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro1rel2spr3tas5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 4
		this.pro1rel2spr4tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 4, Task 1",
						"Beschreibung von Task 1", this.pro1rel2spr4.getSprintBacklog());
		this.pro1rel2spr4.getSprintBacklog().addTask(this.pro1rel2spr4tas1);
		this.pro1rel2spr4tas1.addPBI(this.pro1rel2spr4fea1);
		this.pro1rel2spr4tas1.setPlanEffort(new Effort(1));
		this.pro1rel2spr4tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr4tas1.setResponsibility(this.pBjoern);
		// pro1rel2spr4tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr4tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 4, Task 2",
						"Beschreibung von Task 2", this.pro1rel2spr4.getSprintBacklog());
		this.pro1rel2spr4.getSprintBacklog().addTask(this.pro1rel2spr4tas2);
		this.pro1rel2spr4tas2.addPBI(this.pro1rel2spr4fea2);
		this.pro1rel2spr4tas2.setPlanEffort(new Effort(2));
		this.pro1rel2spr4tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr4tas2.setResponsibility(this.pBjoern);
		this.pro1rel2spr4tas2.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro1rel2spr4tas2.changeState(closedState);

		this.pro1rel2spr4tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 4, Task 3",
						"Beschreibung von Task 3", this.pro1rel2spr4.getSprintBacklog());
		this.pro1rel2spr4.getSprintBacklog().addTask(this.pro1rel2spr4tas3);
		this.pro1rel2spr4tas3.addPBI(this.pro1rel2spr4fea3);
		this.pro1rel2spr4tas3.setPlanEffort(new Effort(6));
		this.pro1rel2spr4tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr4tas3.setResponsibility(this.pBjoern);
		this.pro1rel2spr4tas3.setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.pro1rel2spr4tas3.changeState(closedState);

		this.pro1rel2spr4tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 4, Task 4",
						"Beschreibung von Task 4", this.pro1rel2spr4.getSprintBacklog());
		this.pro1rel2spr4.getSprintBacklog().addTask(this.pro1rel2spr4tas4);
		this.pro1rel2spr4tas4.addPBI(this.pro1rel2spr4fea4);
		this.pro1rel2spr4tas4.setPlanEffort(new Effort(1));
		this.pro1rel2spr4tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr4tas4.setResponsibility(this.pBjoern);
		this.pro1rel2spr4tas4.setFinishDate(new Date(2011 - 1900, 3 - 1, 3, 12, 0));
		this.pro1rel2spr4tas4.changeState(closedState);

		this.pro1rel2spr4tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 4, Task 5",
						"Beschreibung von Task 5", this.pro1rel2spr4.getSprintBacklog());
		this.pro1rel2spr4.getSprintBacklog().addTask(this.pro1rel2spr4tas5);
		this.pro1rel2spr4tas5.addPBI(this.pro1rel2spr4fea5);
		this.pro1rel2spr4tas5.setPlanEffort(new Effort(3));
		this.pro1rel2spr4tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr4tas5.setResponsibility(this.pBjoern);
		this.pro1rel2spr4tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.pro1rel2spr4tas5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 5
		this.pro1rel2spr5tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 5, Task 1",
						"Beschreibung von Task 1", this.pro1rel2spr5.getSprintBacklog());
		this.pro1rel2spr5.getSprintBacklog().addTask(this.pro1rel2spr5tas1);
		this.pro1rel2spr5tas1.addPBI(this.pro1rel2spr5fea1);
		this.pro1rel2spr5tas1.setPlanEffort(new Effort(8));
		this.pro1rel2spr5tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr5tas1.setResponsibility(this.pBjoern);
		// pro1rel2spr5tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr5tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 5, Task 2",
						"Beschreibung von Task 2", this.pro1rel2spr5.getSprintBacklog());
		this.pro1rel2spr5.getSprintBacklog().addTask(this.pro1rel2spr5tas2);
		this.pro1rel2spr5tas2.addPBI(this.pro1rel2spr5fea2);
		this.pro1rel2spr5tas2.setPlanEffort(new Effort(8));
		this.pro1rel2spr5tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr5tas2.setResponsibility(this.pBjoern);
		// pro1rel2spr5tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr5tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 5, Task 3",
						"Beschreibung von Task 3", this.pro1rel2spr5.getSprintBacklog());
		this.pro1rel2spr5.getSprintBacklog().addTask(this.pro1rel2spr5tas3);
		this.pro1rel2spr5tas3.addPBI(this.pro1rel2spr5fea3);
		this.pro1rel2spr5tas3.setPlanEffort(new Effort(8));
		this.pro1rel2spr5tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr5tas3.setResponsibility(this.pBjoern);
		// pro1rel2spr5tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr5tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 5, Task 4",
						"Beschreibung von Task 4", this.pro1rel2spr5.getSprintBacklog());
		this.pro1rel2spr5.getSprintBacklog().addTask(this.pro1rel2spr5tas4);
		this.pro1rel2spr5tas4.addPBI(this.pro1rel2spr5fea4);
		this.pro1rel2spr5tas4.setPlanEffort(new Effort(8));
		this.pro1rel2spr5tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr5tas4.setResponsibility(this.pBjoern);
		// pro1rel2spr5tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.pro1rel2spr5tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 1, Release 2, Sprint 5, Task 5",
						"Beschreibung von Task 5", this.pro1rel2spr5.getSprintBacklog());
		this.pro1rel2spr5.getSprintBacklog().addTask(this.pro1rel2spr5tas5);
		this.pro1rel2spr5tas5.addPBI(this.pro1rel2spr5fea5);
		this.pro1rel2spr5tas5.setPlanEffort(new Effort(8));
		this.pro1rel2spr5tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro1rel2spr5tas5.setResponsibility(this.pBjoern);
		// pro1rel2spr5tas5.getTicketType().getStateProfile().addEndState(closedState);

		// für Projekt 2, Release 1, Sprint 1
		this.pro2rel1spr1tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 1, Task 1",
						"Beschreibung von Task 1", this.pro2rel1spr1.getSprintBacklog());
		this.pro2rel1spr1.getSprintBacklog().addTask(this.pro2rel1spr1tas1);
		this.pro2rel1spr1tas1.addPBI(this.pro2rel1spr1fea1);
		this.pro2rel1spr1tas1.setPlanEffort(new Effort(7));
		this.pro2rel1spr1tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr1tas1.setResponsibility(this.pBjoern);
		this.pro2rel1spr1tas1.setFinishDate(new Date(2011 - 1900, 2 - 1, 1, 12, 0));
		this.pro2rel1spr1tas1.changeState(closedState);

		this.pro2rel1spr1tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 1, Task 2",
						"Beschreibung von Task 2", this.pro2rel1spr1.getSprintBacklog());
		this.pro2rel1spr1.getSprintBacklog().addTask(this.pro2rel1spr1tas2);
		this.pro2rel1spr1tas2.addPBI(this.pro2rel1spr1fea2);
		this.pro2rel1spr1tas2.setPlanEffort(new Effort(3));
		this.pro2rel1spr1tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr1tas2.setResponsibility(this.pBjoern);
		this.pro2rel1spr1tas2.setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.pro2rel1spr1tas2.changeState(closedState);

		this.pro2rel1spr1tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 1, Task 3",
						"Beschreibung von Task 3", this.pro2rel1spr1.getSprintBacklog());
		this.pro2rel1spr1.getSprintBacklog().addTask(this.pro2rel1spr1tas3);
		this.pro2rel1spr1tas3.addPBI(this.pro2rel1spr1fea3);
		this.pro2rel1spr1tas3.setPlanEffort(new Effort(3));
		this.pro2rel1spr1tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr1tas3.setResponsibility(this.pBjoern);
		this.pro2rel1spr1tas3.setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.pro2rel1spr1tas3.changeState(closedState);

		this.pro2rel1spr1tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 1, Task 4",
						"Beschreibung von Task 4", this.pro2rel1spr1.getSprintBacklog());
		this.pro2rel1spr1.getSprintBacklog().addTask(this.pro2rel1spr1tas4);
		this.pro2rel1spr1tas4.addPBI(this.pro2rel1spr1fea4);
		this.pro2rel1spr1tas4.setPlanEffort(new Effort(5));
		this.pro2rel1spr1tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr1tas4.setResponsibility(this.pBjoern);
		this.pro2rel1spr1tas4.setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.pro2rel1spr1tas4.changeState(closedState);

		this.pro2rel1spr1tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 1, Task 5",
						"Beschreibung von Task 5", this.pro2rel1spr1.getSprintBacklog());
		this.pro2rel1spr1.getSprintBacklog().addTask(this.pro2rel1spr1tas5);
		this.pro2rel1spr1tas5.addPBI(this.pro2rel1spr1fea5);
		this.pro2rel1spr1tas5.setPlanEffort(new Effort(4));
		this.pro2rel1spr1tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr1tas5.setResponsibility(this.pBjoern);
		this.pro2rel1spr1tas5.setFinishDate(new Date(2011 - 1900, 2 - 1, 1, 12, 0));
		this.pro2rel1spr1tas5.changeState(closedState);

		// für Projekt 2, Release 1, Sprint 2
		this.pro2rel1spr2tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 2, Task 1",
						"Beschreibung von Task 1", this.pro2rel1spr2.getSprintBacklog());
		this.pro2rel1spr2.getSprintBacklog().addTask(this.pro2rel1spr2tas1);
		this.pro2rel1spr2tas1.addPBI(this.pro2rel1spr2fea1);
		this.pro2rel1spr2tas1.setPlanEffort(new Effort(3));
		this.pro2rel1spr2tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr2tas1.setResponsibility(this.pBjoern);
		// pro2rel1spr2tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel1spr2tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 2, Task 2",
						"Beschreibung von Task 2", this.pro2rel1spr2.getSprintBacklog());
		this.pro2rel1spr2.getSprintBacklog().addTask(this.pro2rel1spr2tas2);
		this.pro2rel1spr2tas2.addPBI(this.pro2rel1spr2fea2);
		this.pro2rel1spr2tas2.setPlanEffort(new Effort(3));
		this.pro2rel1spr2tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr2tas2.setResponsibility(this.pBjoern);
		// pro2rel1spr2tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel1spr2tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 2, Task 3",
						"Beschreibung von Task 3", this.pro2rel1spr2.getSprintBacklog());
		this.pro2rel1spr2.getSprintBacklog().addTask(this.pro2rel1spr2tas3);
		this.pro2rel1spr2tas3.addPBI(this.pro2rel1spr2fea3);
		this.pro2rel1spr2tas3.setPlanEffort(new Effort(3));
		this.pro2rel1spr2tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr2tas3.setResponsibility(this.pBjoern);
		this.pro2rel1spr2tas3.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro2rel1spr2tas3.changeState(closedState);

		this.pro2rel1spr2tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 2, Task 4",
						"Beschreibung von Task 4", this.pro2rel1spr2.getSprintBacklog());
		this.pro2rel1spr2.getSprintBacklog().addTask(this.pro2rel1spr2tas4);
		this.pro2rel1spr2tas4.addPBI(this.pro2rel1spr2fea4);
		this.pro2rel1spr2tas4.setPlanEffort(new Effort(3));
		this.pro2rel1spr2tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr2tas4.setResponsibility(this.pBjoern);
		this.pro2rel1spr2tas4.setFinishDate(new Date(2011 - 1900, 3 - 1, 15, 12, 0));
		this.pro2rel1spr2tas4.changeState(closedState);

		this.pro2rel1spr2tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 2, Task 5",
						"Beschreibung von Task 5", this.pro2rel1spr2.getSprintBacklog());
		this.pro2rel1spr2.getSprintBacklog().addTask(this.pro2rel1spr2tas5);
		this.pro2rel1spr2tas5.addPBI(this.pro2rel1spr2fea5);
		this.pro2rel1spr2tas5.setPlanEffort(new Effort(3));
		this.pro2rel1spr2tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr2tas5.setResponsibility(this.pBjoern);
		this.pro2rel1spr2tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 30, 12, 0));
		this.pro2rel1spr2tas5.changeState(closedState);

		// für Projekt 2, Release 1, Sprint 3
		this.pro2rel1spr3tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 3, Task 1",
						"Beschreibung von Task 1", this.pro2rel1spr3.getSprintBacklog());
		this.pro2rel1spr3.getSprintBacklog().addTask(this.pro2rel1spr3tas1);
		this.pro2rel1spr3tas1.addPBI(this.pro2rel1spr3fea1);
		this.pro2rel1spr3tas1.setPlanEffort(new Effort(3));
		this.pro2rel1spr3tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr3tas1.setResponsibility(this.pBjoern);
		this.pro2rel1spr3tas1.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro2rel1spr3tas1.changeState(closedState);

		this.pro2rel1spr3tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 3, Task 2",
						"Beschreibung von Task 2", this.pro2rel1spr3.getSprintBacklog());
		this.pro2rel1spr3.getSprintBacklog().addTask(this.pro2rel1spr3tas2);
		this.pro2rel1spr3tas2.addPBI(this.pro2rel1spr3fea2);
		this.pro2rel1spr3tas2.setPlanEffort(new Effort(6));
		this.pro2rel1spr3tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr3tas2.setResponsibility(this.pBjoern);
		this.pro2rel1spr3tas2.setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.pro2rel1spr3tas2.changeState(closedState);

		this.pro2rel1spr3tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 3, Task 3",
						"Beschreibung von Task 3", this.pro2rel1spr3.getSprintBacklog());
		this.pro2rel1spr3.getSprintBacklog().addTask(this.pro2rel1spr3tas3);
		this.pro2rel1spr3tas3.addPBI(this.pro2rel1spr3fea3);
		this.pro2rel1spr3tas3.setPlanEffort(new Effort(2));
		this.pro2rel1spr3tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr3tas3.setResponsibility(this.pBjoern);
		this.pro2rel1spr3tas3.setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.pro2rel1spr3tas3.changeState(closedState);

		this.pro2rel1spr3tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 3, Task 4",
						"Beschreibung von Task 4", this.pro2rel1spr3.getSprintBacklog());
		this.pro2rel1spr3.getSprintBacklog().addTask(this.pro2rel1spr3tas4);
		this.pro2rel1spr3tas4.addPBI(this.pro2rel1spr3fea4);
		this.pro2rel1spr3tas4.setPlanEffort(new Effort(3));
		this.pro2rel1spr3tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr3tas4.setResponsibility(this.pBjoern);
		// pro2rel1spr3tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel1spr3tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 3, Task 5",
						"Beschreibung von Task 5", this.pro2rel1spr3.getSprintBacklog());
		this.pro2rel1spr3.getSprintBacklog().addTask(this.pro2rel1spr3tas5);
		this.pro2rel1spr3tas5.addPBI(this.pro2rel1spr3fea5);
		this.pro2rel1spr3tas5.setPlanEffort(new Effort(6));
		this.pro2rel1spr3tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr3tas5.setResponsibility(this.pBjoern);
		// pro2rel1spr3tas5.getTicketType().getStateProfile().addEndState(closedState);

		// für Projekt 2, Release 1, Sprint 4
		this.pro2rel1spr4tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 4, Task 1",
						"Beschreibung von Task 1", this.pro2rel1spr4.getSprintBacklog());
		this.pro2rel1spr4.getSprintBacklog().addTask(this.pro2rel1spr4tas1);
		this.pro2rel1spr4tas1.addPBI(this.pro2rel1spr4fea1);
		this.pro2rel1spr4tas1.setPlanEffort(new Effort(4));
		this.pro2rel1spr4tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr4tas1.setResponsibility(this.pBjoern);
		// pro2rel1spr4tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel1spr4tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 4, Task 2",
						"Beschreibung von Task 2", this.pro2rel1spr4.getSprintBacklog());
		this.pro2rel1spr4.getSprintBacklog().addTask(this.pro2rel1spr4tas2);
		this.pro2rel1spr4tas2.addPBI(this.pro2rel1spr4fea2);
		this.pro2rel1spr4tas2.setPlanEffort(new Effort(6));
		this.pro2rel1spr4tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr4tas2.setResponsibility(this.pBjoern);
		// pro2rel1spr4tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel1spr4tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 4, Task 3",
						"Beschreibung von Task 3", this.pro2rel1spr4.getSprintBacklog());
		this.pro2rel1spr4.getSprintBacklog().addTask(this.pro2rel1spr4tas3);
		this.pro2rel1spr4tas3.addPBI(this.pro2rel1spr4fea3);
		this.pro2rel1spr4tas3.setPlanEffort(new Effort(7));
		this.pro2rel1spr4tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr4tas3.setResponsibility(this.pBjoern);
		// pro2rel1spr4tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel1spr4tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 4, Task 4",
						"Beschreibung von Task 4", this.pro2rel1spr4.getSprintBacklog());
		this.pro2rel1spr4.getSprintBacklog().addTask(this.pro2rel1spr4tas4);
		this.pro2rel1spr4tas4.addPBI(this.pro2rel1spr4fea4);
		this.pro2rel1spr4tas4.setPlanEffort(new Effort(8));
		this.pro2rel1spr4tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr4tas4.setResponsibility(this.pBjoern);
		// pro2rel1spr4tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel1spr4tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 4, Task 5",
						"Beschreibung von Task 5", this.pro2rel1spr4.getSprintBacklog());
		this.pro2rel1spr4.getSprintBacklog().addTask(this.pro2rel1spr4tas5);
		this.pro2rel1spr4tas5.addPBI(this.pro2rel1spr4fea5);
		this.pro2rel1spr4tas5.setPlanEffort(new Effort(1));
		this.pro2rel1spr4tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr4tas5.setResponsibility(this.pBjoern);
		this.pro2rel1spr4tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 17, 12, 0));
		this.pro2rel1spr4tas5.changeState(closedState);

		// für Projekt 2, Release 1, Sprint 5
		this.pro2rel1spr5tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 5, Task 1",
						"Beschreibung von Task 1", this.pro2rel1spr5.getSprintBacklog());
		this.pro2rel1spr5.getSprintBacklog().addTask(this.pro2rel1spr5tas1);
		this.pro2rel1spr5tas1.addPBI(this.pro2rel1spr5fea1);
		this.pro2rel1spr5tas1.setPlanEffort(new Effort(2));
		this.pro2rel1spr5tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr5tas1.setResponsibility(this.pBjoern);
		// pro2rel1spr5tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel1spr5tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 5, Task 2",
						"Beschreibung von Task 2", this.pro2rel1spr5.getSprintBacklog());
		this.pro2rel1spr5.getSprintBacklog().addTask(this.pro2rel1spr5tas2);
		this.pro2rel1spr5tas2.addPBI(this.pro2rel1spr5fea2);
		this.pro2rel1spr5tas2.setPlanEffort(new Effort(8));
		this.pro2rel1spr5tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr5tas2.setResponsibility(this.pBjoern);
		this.pro2rel1spr5tas2.setFinishDate(new Date(2011 - 1900, 3 - 1, 14, 12, 0));
		this.pro2rel1spr5tas2.changeState(closedState);

		this.pro2rel1spr5tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 5, Task 3",
						"Beschreibung von Task 3", this.pro2rel1spr5.getSprintBacklog());
		this.pro2rel1spr5.getSprintBacklog().addTask(this.pro2rel1spr5tas3);
		this.pro2rel1spr5tas3.addPBI(this.pro2rel1spr5fea3);
		this.pro2rel1spr5tas3.setPlanEffort(new Effort(3));
		this.pro2rel1spr5tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr5tas3.setResponsibility(this.pBjoern);
		// pro2rel1spr5tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel1spr5tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 5, Task 4",
						"Beschreibung von Task 4", this.pro2rel1spr5.getSprintBacklog());
		this.pro2rel1spr5.getSprintBacklog().addTask(this.pro2rel1spr5tas4);
		this.pro2rel1spr5tas4.addPBI(this.pro2rel1spr5fea4);
		this.pro2rel1spr5tas4.setPlanEffort(new Effort(5));
		this.pro2rel1spr5tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr5tas4.setResponsibility(this.pBjoern);
		this.pro2rel1spr5tas4.setFinishDate(new Date(2011 - 1900, 3 - 1, 14, 12, 0));
		this.pro2rel1spr5tas4.changeState(closedState);

		this.pro2rel1spr5tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 1, Sprint 5, Task 5",
						"Beschreibung von Task 5", this.pro2rel1spr5.getSprintBacklog());
		this.pro2rel1spr5.getSprintBacklog().addTask(this.pro2rel1spr5tas5);
		this.pro2rel1spr5tas5.addPBI(this.pro2rel1spr5fea5);
		this.pro2rel1spr5tas5.setPlanEffort(new Effort(3));
		this.pro2rel1spr5tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel1spr5tas5.setResponsibility(this.pBjoern);
		this.pro2rel1spr5tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 7, 12, 0));
		this.pro2rel1spr5tas5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 1
		this.pro2rel2spr1tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 1, Task 1",
						"Beschreibung von Task 1", this.pro2rel2spr1.getSprintBacklog());
		this.pro2rel2spr1.getSprintBacklog().addTask(this.pro2rel2spr1tas1);
		this.pro2rel2spr1tas1.addPBI(this.pro2rel2spr1fea1);
		this.pro2rel2spr1tas1.setPlanEffort(new Effort(5));
		this.pro2rel2spr1tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr1tas1.setResponsibility(this.pBjoern);
		// pro2rel2spr1tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel2spr1tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 1, Task 2",
						"Beschreibung von Task 2", this.pro2rel2spr1.getSprintBacklog());
		this.pro2rel2spr1.getSprintBacklog().addTask(this.pro2rel2spr1tas2);
		this.pro2rel2spr1tas2.addPBI(this.pro2rel2spr1fea2);
		this.pro2rel2spr1tas2.setPlanEffort(new Effort(5));
		this.pro2rel2spr1tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr1tas2.setResponsibility(this.pBjoern);
		// pro2rel2spr1tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel2spr1tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 1, Task 3",
						"Beschreibung von Task 3", this.pro2rel2spr1.getSprintBacklog());
		this.pro2rel2spr1.getSprintBacklog().addTask(this.pro2rel2spr1tas3);
		this.pro2rel2spr1tas3.addPBI(this.pro2rel2spr1fea3);
		this.pro2rel2spr1tas3.setPlanEffort(new Effort(5));
		this.pro2rel2spr1tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr1tas3.setResponsibility(this.pBjoern);
		// pro2rel2spr1tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel2spr1tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 1, Task 4",
						"Beschreibung von Task 4", this.pro2rel2spr1.getSprintBacklog());
		this.pro2rel2spr1.getSprintBacklog().addTask(this.pro2rel2spr1tas4);
		this.pro2rel2spr1tas4.addPBI(this.pro2rel2spr1fea4);
		this.pro2rel2spr1tas4.setPlanEffort(new Effort(5));
		this.pro2rel2spr1tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr1tas4.setResponsibility(this.pBjoern);
		// pro2rel2spr1tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel2spr1tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 1, Task 5",
						"Beschreibung von Task 5", this.pro2rel2spr1.getSprintBacklog());
		this.pro2rel2spr1.getSprintBacklog().addTask(this.pro2rel2spr1tas5);
		this.pro2rel2spr1tas5.addPBI(this.pro2rel2spr1fea5);
		this.pro2rel2spr1tas5.setPlanEffort(new Effort(5));
		this.pro2rel2spr1tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr1tas5.setResponsibility(this.pBjoern);
		this.pro2rel2spr1tas5.setFinishDate(new Date(2011 - 1900, 6 - 1, 13, 12, 0));
		this.pro2rel2spr1tas5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 2
		this.pro2rel2spr2tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 2, Task 1",
						"Beschreibung von Task 1", this.pro2rel2spr2.getSprintBacklog());
		this.pro2rel2spr2.getSprintBacklog().addTask(this.pro2rel2spr2tas1);
		this.pro2rel2spr2tas1.addPBI(this.pro2rel2spr2fea1);
		this.pro2rel2spr2tas1.setPlanEffort(new Effort(5));
		this.pro2rel2spr2tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr2tas1.setResponsibility(this.pBjoern);
		// pro2rel2spr2tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel2spr2tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 2, Task 2",
						"Beschreibung von Task 2", this.pro2rel2spr2.getSprintBacklog());
		this.pro2rel2spr2.getSprintBacklog().addTask(this.pro2rel2spr2tas2);
		this.pro2rel2spr2tas2.addPBI(this.pro2rel2spr2fea2);
		this.pro2rel2spr2tas2.setPlanEffort(new Effort(5));
		this.pro2rel2spr2tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr2tas2.setResponsibility(this.pBjoern);
		this.pro2rel2spr2tas2.setFinishDate(new Date(2011 - 1900, 2 - 1, 11, 12, 0));
		this.pro2rel2spr2tas2.changeState(closedState);

		this.pro2rel2spr2tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 2, Task 3",
						"Beschreibung von Task 3", this.pro2rel2spr2.getSprintBacklog());
		this.pro2rel2spr2.getSprintBacklog().addTask(this.pro2rel2spr2tas3);
		this.pro2rel2spr2tas3.addPBI(this.pro2rel2spr2fea3);
		this.pro2rel2spr2tas3.setPlanEffort(new Effort(5));
		this.pro2rel2spr2tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr2tas3.setResponsibility(this.pBjoern);
		this.pro2rel2spr2tas3.setFinishDate(new Date(2011 - 1900, 2 - 1, 12, 12, 0));
		this.pro2rel2spr2tas3.changeState(closedState);

		this.pro2rel2spr2tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 2, Task 4",
						"Beschreibung von Task 4", this.pro2rel2spr2.getSprintBacklog());
		this.pro2rel2spr2.getSprintBacklog().addTask(this.pro2rel2spr2tas4);
		this.pro2rel2spr2tas4.addPBI(this.pro2rel2spr2fea4);
		this.pro2rel2spr2tas4.setPlanEffort(new Effort(5));
		this.pro2rel2spr2tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr2tas4.setResponsibility(this.pBjoern);
		// pro2rel2spr2tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel2spr2tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 2, Task 5",
						"Beschreibung von Task 5", this.pro2rel2spr2.getSprintBacklog());
		this.pro2rel2spr2.getSprintBacklog().addTask(this.pro2rel2spr2tas5);
		this.pro2rel2spr2tas5.addPBI(this.pro2rel2spr2fea5);
		this.pro2rel2spr2tas5.setPlanEffort(new Effort(5));
		this.pro2rel2spr2tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr2tas5.setResponsibility(this.pBjoern);
		this.pro2rel2spr2tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro2rel2spr2tas5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 3
		this.pro2rel2spr3tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 3, Task 1",
						"Beschreibung von Task 1", this.pro2rel2spr3.getSprintBacklog());
		this.pro2rel2spr3.getSprintBacklog().addTask(this.pro2rel2spr3tas1);
		this.pro2rel2spr3tas1.addPBI(this.pro2rel2spr3fea1);
		this.pro2rel2spr3tas1.setPlanEffort(new Effort(5));
		this.pro2rel2spr3tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr3tas1.setResponsibility(this.pBjoern);
		this.pro2rel2spr3tas1.setFinishDate(new Date(2011 - 1900, 1 - 1, 1, 12, 0));
		this.pro2rel2spr3tas1.changeState(closedState);

		this.pro2rel2spr3tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 3, Task 2",
						"Beschreibung von Task 2", this.pro2rel2spr3.getSprintBacklog());
		this.pro2rel2spr3.getSprintBacklog().addTask(this.pro2rel2spr3tas2);
		this.pro2rel2spr3tas2.addPBI(this.pro2rel2spr3fea2);
		this.pro2rel2spr3tas2.setPlanEffort(new Effort(5));
		this.pro2rel2spr3tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr3tas2.setResponsibility(this.pBjoern);
		this.pro2rel2spr3tas2.setFinishDate(new Date(2011 - 1900, 1 - 1, 2, 12, 0));
		this.pro2rel2spr3tas2.changeState(closedState);

		this.pro2rel2spr3tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 3, Task 3",
						"Beschreibung von Task 3", this.pro2rel2spr3.getSprintBacklog());
		this.pro2rel2spr3.getSprintBacklog().addTask(this.pro2rel2spr3tas3);
		this.pro2rel2spr3tas3.addPBI(this.pro2rel2spr3fea3);
		this.pro2rel2spr3tas3.setPlanEffort(new Effort(5));
		this.pro2rel2spr3tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr3tas3.setResponsibility(this.pBjoern);
		this.pro2rel2spr3tas3.setFinishDate(new Date(2011 - 1900, 1 - 1, 11, 12, 0));
		this.pro2rel2spr3tas3.changeState(closedState);

		this.pro2rel2spr3tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 3, Task 4",
						"Beschreibung von Task 4", this.pro2rel2spr3.getSprintBacklog());
		this.pro2rel2spr3.getSprintBacklog().addTask(this.pro2rel2spr3tas4);
		this.pro2rel2spr3tas4.addPBI(this.pro2rel2spr3fea4);
		this.pro2rel2spr3tas4.setPlanEffort(new Effort(5));
		this.pro2rel2spr3tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr3tas4.setResponsibility(this.pBjoern);
		// pro2rel2spr3tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.pro2rel2spr3tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 3, Task 5",
						"Beschreibung von Task 5", this.pro2rel2spr3.getSprintBacklog());
		this.pro2rel2spr3.getSprintBacklog().addTask(this.pro2rel2spr3tas5);
		this.pro2rel2spr3tas5.addPBI(this.pro2rel2spr3fea5);
		this.pro2rel2spr3tas5.setPlanEffort(new Effort(5));
		this.pro2rel2spr3tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr3tas5.setResponsibility(this.pBjoern);
		// pro2rel2spr3tas5.getTicketType().getStateProfile().addEndState(closedState);

		// für Projekt 2, Release 2, Sprint 4
		this.pro2rel2spr4tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 4, Task 1",
						"Beschreibung von Task 1", this.pro2rel2spr4.getSprintBacklog());
		this.pro2rel2spr4.getSprintBacklog().addTask(this.pro2rel2spr4tas1);
		this.pro2rel2spr4tas1.addPBI(this.pro2rel2spr4fea1);
		this.pro2rel2spr4tas1.setPlanEffort(new Effort(5));
		this.pro2rel2spr4tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr4tas1.setResponsibility(this.pBjoern);
		this.pro2rel2spr4tas1.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro2rel2spr4tas1.changeState(closedState);

		this.pro2rel2spr4tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 4, Task 2",
						"Beschreibung von Task 2", this.pro2rel2spr4.getSprintBacklog());
		this.pro2rel2spr4.getSprintBacklog().addTask(this.pro2rel2spr4tas2);
		this.pro2rel2spr4tas2.addPBI(this.pro2rel2spr4fea2);
		this.pro2rel2spr4tas2.setPlanEffort(new Effort(5));
		this.pro2rel2spr4tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr4tas2.setResponsibility(this.pBjoern);
		this.pro2rel2spr4tas2.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro2rel2spr4tas2.changeState(closedState);

		this.pro2rel2spr4tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 4, Task 3",
						"Beschreibung von Task 3", this.pro2rel2spr4.getSprintBacklog());
		this.pro2rel2spr4.getSprintBacklog().addTask(this.pro2rel2spr4tas3);
		this.pro2rel2spr4tas3.addPBI(this.pro2rel2spr4fea3);
		this.pro2rel2spr4tas3.setPlanEffort(new Effort(5));
		this.pro2rel2spr4tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr4tas3.setResponsibility(this.pBjoern);
		this.pro2rel2spr4tas3.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro2rel2spr4tas3.changeState(closedState);

		this.pro2rel2spr4tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 4, Task 4",
						"Beschreibung von Task 4", this.pro2rel2spr4.getSprintBacklog());
		this.pro2rel2spr4.getSprintBacklog().addTask(this.pro2rel2spr4tas4);
		this.pro2rel2spr4tas4.addPBI(this.pro2rel2spr4fea4);
		this.pro2rel2spr4tas4.setPlanEffort(new Effort(5));
		this.pro2rel2spr4tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr4tas4.setResponsibility(this.pBjoern);
		this.pro2rel2spr4tas4.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro2rel2spr4tas4.changeState(closedState);

		this.pro2rel2spr4tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 4, Task 5",
						"Beschreibung von Task 5", this.pro2rel2spr4.getSprintBacklog());
		this.pro2rel2spr4.getSprintBacklog().addTask(this.pro2rel2spr4tas5);
		this.pro2rel2spr4tas5.addPBI(this.pro2rel2spr4fea5);
		this.pro2rel2spr4tas5.setPlanEffort(new Effort(5));
		this.pro2rel2spr4tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr4tas5.setResponsibility(this.pBjoern);
		this.pro2rel2spr4tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.pro2rel2spr4tas5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 5
		this.pro2rel2spr5tas1 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 5, Task 1",
						"Beschreibung von Task 1", this.pro2rel2spr5.getSprintBacklog());
		this.pro2rel2spr5.getSprintBacklog().addTask(this.pro2rel2spr5tas1);
		this.pro2rel2spr5tas1.addPBI(this.pro2rel2spr5fea1);
		this.pro2rel2spr5tas1.setPlanEffort(new Effort(5));
		this.pro2rel2spr5tas1.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr5tas1.setResponsibility(this.pBjoern);
		this.pro2rel2spr5tas1.setFinishDate(new Date(2011 - 1900, 2 - 1, 27, 12, 0));
		this.pro2rel2spr5tas1.changeState(closedState);

		this.pro2rel2spr5tas2 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 5, Task 2",
						"Beschreibung von Task 2", this.pro2rel2spr5.getSprintBacklog());
		this.pro2rel2spr5.getSprintBacklog().addTask(this.pro2rel2spr5tas2);
		this.pro2rel2spr5tas2.addPBI(this.pro2rel2spr5fea2);
		this.pro2rel2spr5tas2.setPlanEffort(new Effort(5));
		this.pro2rel2spr5tas2.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr5tas2.setResponsibility(this.pBjoern);
		this.pro2rel2spr5tas2.setFinishDate(new Date(2011 - 1900, 2 - 1, 27, 12, 0));
		this.pro2rel2spr5tas2.changeState(closedState);

		this.pro2rel2spr5tas3 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 5, Task 3",
						"Beschreibung von Task 3", this.pro2rel2spr5.getSprintBacklog());
		this.pro2rel2spr5.getSprintBacklog().addTask(this.pro2rel2spr5tas3);
		this.pro2rel2spr5tas3.addPBI(this.pro2rel2spr5fea3);
		this.pro2rel2spr5tas3.setPlanEffort(new Effort(5));
		this.pro2rel2spr5tas3.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr5tas3.setResponsibility(this.pBjoern);
		this.pro2rel2spr5tas3.setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.pro2rel2spr5tas3.changeState(closedState);

		this.pro2rel2spr5tas4 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 5, Task 4",
						"Beschreibung von Task 4", this.pro2rel2spr5.getSprintBacklog());
		this.pro2rel2spr5.getSprintBacklog().addTask(this.pro2rel2spr5tas4);
		this.pro2rel2spr5tas4.addPBI(this.pro2rel2spr5fea4);
		this.pro2rel2spr5tas4.setPlanEffort(new Effort(5));
		this.pro2rel2spr5tas4.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr5tas4.setResponsibility(this.pBjoern);
		this.pro2rel2spr5tas4.setFinishDate(new Date(2011 - 1900, 3 - 1, 3, 12, 0));
		this.pro2rel2spr5tas4.changeState(closedState);

		this.pro2rel2spr5tas5 =
				new Task(this.model, taskTicketType,
						"Projekt 2, Release 2, Sprint 5, Task 5",
						"Beschreibung von Task 5", this.pro2rel2spr5.getSprintBacklog());
		this.pro2rel2spr5.getSprintBacklog().addTask(this.pro2rel2spr5tas5);
		this.pro2rel2spr5tas5.addPBI(this.pro2rel2spr5fea5);
		this.pro2rel2spr5tas5.setPlanEffort(new Effort(5));
		this.pro2rel2spr5tas5.changeState(this.model.getTypeManager().getInProcess());
		this.pro2rel2spr5tas5.setResponsibility(this.pBjoern);
		this.pro2rel2spr5tas5.setFinishDate(new Date(2011 - 1900, 3 - 1, 7, 12, 0));
		this.pro2rel2spr5tas5.changeState(closedState);

		this.listOfFeatures = new ArrayList<ProductBacklogItem>();
		this.listOfFeatures.add(this.pro1rel2spr1fea1);
		this.listOfFeatures.add(this.pro1rel1spr5fea5);
		this.listOfFeatures.add(this.pro1rel1spr1fea1);
		this.listOfFeatures.add(this.pro1rel1spr1fea2);
		this.listOfFeatures.add(this.pro1rel1spr1fea3);
		this.listOfFeatures.add(this.pro1rel1spr1fea4);
		this.listOfFeatures.add(this.pro1rel1spr1fea5);
		this.listOfFeatures.add(this.pro1rel1spr2fea1);
		this.listOfFeatures.add(this.pro1rel1spr2fea2);
		this.listOfFeatures.add(this.pro1rel1spr2fea3);
		this.listOfFeatures.add(this.pro1rel1spr2fea4);
		this.listOfFeatures.add(this.pro1rel1spr2fea5);
		this.listOfFeatures.add(this.pro1rel1spr3fea1);
		this.listOfFeatures.add(this.pro1rel1spr3fea2);
		this.listOfFeatures.add(this.pro1rel1spr3fea3);
		this.listOfFeatures.add(this.pro1rel1spr3fea4);
		this.listOfFeatures.add(this.pro1rel1spr3fea5);
		this.listOfFeatures.add(this.pro1rel1spr4fea1);
		this.listOfFeatures.add(this.pro1rel1spr4fea2);
		this.listOfFeatures.add(this.pro1rel1spr4fea3);
		this.listOfFeatures.add(this.pro1rel1spr4fea4);
		this.listOfFeatures.add(this.pro1rel1spr4fea5);
		this.listOfFeatures.add(this.pro1rel1spr5fea1);
		this.listOfFeatures.add(this.pro1rel1spr5fea2);
		this.listOfFeatures.add(this.pro1rel1spr5fea3);
		this.listOfFeatures.add(this.pro1rel1spr5fea4);
		this.listOfFeatures.add(this.pro1rel2spr1fea2);
		this.listOfFeatures.add(this.pro1rel2spr1fea3);
		this.listOfFeatures.add(this.pro1rel2spr1fea4);
		this.listOfFeatures.add(this.pro1rel2spr1fea5);
		this.listOfFeatures.add(this.pro1rel2spr2fea1);
		this.listOfFeatures.add(this.pro1rel2spr2fea2);
		this.listOfFeatures.add(this.pro1rel2spr2fea3);
		this.listOfFeatures.add(this.pro1rel2spr2fea4);
		this.listOfFeatures.add(this.pro1rel2spr2fea5);
		this.listOfFeatures.add(this.pro1rel2spr3fea1);
		this.listOfFeatures.add(this.pro1rel2spr3fea2);
		this.listOfFeatures.add(this.pro1rel2spr3fea3);
		this.listOfFeatures.add(this.pro1rel2spr3fea4);
		this.listOfFeatures.add(this.pro1rel2spr3fea5);
		this.listOfFeatures.add(this.pro1rel2spr4fea1);
		this.listOfFeatures.add(this.pro1rel2spr4fea2);
		this.listOfFeatures.add(this.pro1rel2spr4fea3);
		this.listOfFeatures.add(this.pro1rel2spr4fea4);
		this.listOfFeatures.add(this.pro1rel2spr4fea5);
		this.listOfFeatures.add(this.pro1rel2spr5fea1);
		this.listOfFeatures.add(this.pro1rel2spr5fea2);
		this.listOfFeatures.add(this.pro1rel2spr5fea3);
		this.listOfFeatures.add(this.pro1rel2spr5fea4);
		this.listOfFeatures.add(this.pro1rel2spr5fea5);
		this.listOfFeatures.add(this.pro2rel1spr1fea1);
		this.listOfFeatures.add(this.pro2rel1spr1fea2);
		this.listOfFeatures.add(this.pro2rel1spr1fea3);
		this.listOfFeatures.add(this.pro2rel1spr1fea4);
		this.listOfFeatures.add(this.pro2rel1spr1fea5);
		this.listOfFeatures.add(this.pro2rel1spr2fea1);
		this.listOfFeatures.add(this.pro2rel1spr2fea2);
		this.listOfFeatures.add(this.pro2rel1spr2fea3);
		this.listOfFeatures.add(this.pro2rel1spr2fea4);
		this.listOfFeatures.add(this.pro2rel1spr2fea5);
		this.listOfFeatures.add(this.pro2rel1spr3fea1);
		this.listOfFeatures.add(this.pro2rel1spr3fea2);
		this.listOfFeatures.add(this.pro2rel1spr3fea3);
		this.listOfFeatures.add(this.pro2rel1spr3fea4);
		this.listOfFeatures.add(this.pro2rel1spr3fea5);
		this.listOfFeatures.add(this.pro2rel1spr4fea1);
		this.listOfFeatures.add(this.pro2rel1spr4fea2);
		this.listOfFeatures.add(this.pro2rel1spr4fea3);
		this.listOfFeatures.add(this.pro2rel1spr4fea4);
		this.listOfFeatures.add(this.pro2rel1spr4fea5);
		this.listOfFeatures.add(this.pro2rel1spr5fea1);
		this.listOfFeatures.add(this.pro2rel1spr5fea2);
		this.listOfFeatures.add(this.pro2rel1spr5fea3);
		this.listOfFeatures.add(this.pro2rel1spr5fea4);
		this.listOfFeatures.add(this.pro2rel1spr5fea5);
		this.listOfFeatures.add(this.pro2rel2spr1fea1);
		this.listOfFeatures.add(this.pro2rel2spr1fea2);
		this.listOfFeatures.add(this.pro2rel2spr1fea3);
		this.listOfFeatures.add(this.pro2rel2spr1fea4);
		this.listOfFeatures.add(this.pro2rel2spr1fea5);
		this.listOfFeatures.add(this.pro2rel2spr2fea1);
		this.listOfFeatures.add(this.pro2rel2spr2fea2);
		this.listOfFeatures.add(this.pro2rel2spr2fea3);
		this.listOfFeatures.add(this.pro2rel2spr2fea4);
		this.listOfFeatures.add(this.pro2rel2spr2fea5);
		this.listOfFeatures.add(this.pro2rel2spr3fea1);
		this.listOfFeatures.add(this.pro2rel2spr3fea2);
		this.listOfFeatures.add(this.pro2rel2spr3fea3);
		this.listOfFeatures.add(this.pro2rel2spr3fea4);
		this.listOfFeatures.add(this.pro2rel2spr3fea5);
		this.listOfFeatures.add(this.pro2rel2spr4fea1);
		this.listOfFeatures.add(this.pro2rel2spr4fea2);
		this.listOfFeatures.add(this.pro2rel2spr4fea3);
		this.listOfFeatures.add(this.pro2rel2spr4fea4);
		this.listOfFeatures.add(this.pro2rel2spr4fea5);
		this.listOfFeatures.add(this.pro2rel2spr5fea1);
		this.listOfFeatures.add(this.pro2rel2spr5fea2);
		this.listOfFeatures.add(this.pro2rel2spr5fea3);
		this.listOfFeatures.add(this.pro2rel2spr5fea4);
		this.listOfFeatures.add(this.pro2rel2spr5fea5);

		this.pro1rel1.addSprint(this.pro1rel1spr1);
		this.pro1rel1.addSprint(this.pro1rel1spr2);
		this.pro1rel1.addSprint(this.pro1rel1spr3);
		this.pro1rel1.addSprint(this.pro1rel1spr4);
		this.pro1rel1.addSprint(this.pro1rel1spr5);
		this.pro1rel2.addSprint(this.pro1rel2spr1);
		this.pro1rel2.addSprint(this.pro1rel2spr2);
		this.pro1rel2.addSprint(this.pro1rel2spr3);
		this.pro1rel2.addSprint(this.pro1rel2spr4);
		this.pro1rel2.addSprint(this.pro1rel2spr5);
		this.pro2rel1.addSprint(this.pro2rel1spr1);
		this.pro2rel1.addSprint(this.pro2rel1spr2);
		this.pro2rel1.addSprint(this.pro2rel1spr3);
		this.pro2rel1.addSprint(this.pro2rel1spr4);
		this.pro2rel1.addSprint(this.pro2rel1spr5);
		this.pro2rel2.addSprint(this.pro2rel2spr1);
		this.pro2rel2.addSprint(this.pro2rel2spr2);
		this.pro2rel2.addSprint(this.pro2rel2spr3);
		this.pro2rel2.addSprint(this.pro2rel2spr4);
		this.pro2rel2.addSprint(this.pro2rel2spr5);
		this.pro3rel1.addSprint(this.pro3rel1spr1);
		this.pro3rel1.addSprint(this.pro3rel1spr2);
		this.pro3rel1.addSprint(this.pro3rel1spr3);
		this.pro3rel1.addSprint(this.pro3rel1spr4);
		this.pro3rel1.addSprint(this.pro3rel1spr5);
		this.pro3rel2.addSprint(this.pro3rel2spr1);
		this.pro3rel2.addSprint(this.pro3rel2spr2);
		this.pro3rel2.addSprint(this.pro3rel2spr3);
		this.pro3rel2.addSprint(this.pro3rel2spr4);
		this.pro3rel2.addSprint(this.pro3rel2spr5);
	}

}
