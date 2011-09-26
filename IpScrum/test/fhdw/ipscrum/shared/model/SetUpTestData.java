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
 * This class is needed to build a model with all aspects of the IPScrum, to deliver data for the tests.
 */
public abstract class SetUpTestData {
	/**
	 * represents the model needed to use the IPScrum.
	 */
	private Model model;
	/**
	 * represents the feature of the first sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr1fea1;
	/**
	 * represents the feature of the fifth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr5fea5;
	/**
	 * represents the feature of the first sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr1fea1;
	/**
	 * represents the feature of the first sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr1fea2;
	/**
	 * represents the feature of the first sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr1fea3;
	/**
	 * represents the feature of the first sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr1fea4;
	/**
	 * represents the feature of the first sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr1fea5;
	/**
	 * represents the feature of the second sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr2fea1;
	/**
	 * represents the feature of the second sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr2fea2;
	/**
	 * represents the feature of the second sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr2fea3;
	/**
	 * represents the feature of the second sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr2fea4;
	/**
	 * represents the feature of the second sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr2fea5;
	/**
	 * represents the feature of the third sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr3fea1;
	/**
	 * represents the feature of the third sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr3fea2;
	/**
	 * represents the feature of the third sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr3fea3;
	/**
	 * represents the feature of the third sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr3fea4;
	/**
	 * represents the feature of the third sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr3fea5;
	/**
	 * represents the feature of the fourth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr4fea1;
	/**
	 * represents the feature of the fourth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr4fea2;
	/**
	 * represents the feature of the fourth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr4fea3;
	/**
	 * represents the feature of the fourth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr4fea4;
	/**
	 * represents the feature of the fourth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr4fea5;
	/**
	 * represents the feature of the fifth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr5fea1;
	/**
	 * represents the feature of the fifth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr5fea2;
	/**
	 * represents the feature of the fifth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr5fea3;
	/**
	 * represents the feature of the fifth sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel1spr5fea4;
	/**
	 * represents the feature of the first sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr1fea2;
	/**
	 * represents the feature of the first sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr1fea3;
	/**
	 * represents the feature of the first sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr1fea4;
	/**
	 * represents the feature of the first sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr1fea5;
	/**
	 * represents the feature of the second sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr2fea1;
	/**
	 * represents the feature of the first sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr2fea2;
	/**
	 * represents the feature of the first sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr2fea3;
	/**
	 * represents the feature of the first sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr2fea4;
	/**
	 * represents the feature of the first sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr2fea5;
	/**
	 * represents the feature of the third sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr3fea1;
	/**
	 * represents the feature of the third sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr3fea2;
	/**
	 * represents the feature of the third sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr3fea3;
	/**
	 * represents the feature of the third sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr3fea4;
	/**
	 * represents the feature of the third sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr3fea5;
	/**
	 * represents the feature of the fourth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr4fea1;
	/**
	 * represents the feature of the fourth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr4fea2;
	/**
	 * represents the feature of the fourth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr4fea3;
	/**
	 * represents the feature of the fourth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr4fea4;
	/**
	 * represents the feature of the fourth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr4fea5;
	/**
	 * represents the feature of the fifth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr5fea1;
	/**
	 * represents the feature of the fifth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr5fea2;
	/**
	 * represents the feature of the fifth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr5fea3;
	/**
	 * represents the feature of the fifth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr5fea4;
	/**
	 * represents the feature of the fifth sprint of the second release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro1rel2spr5fea5;
	/**
	 * represents the feature of the first sprint of the first release of project one which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr1fea1;
	/**
	 * represents the feature of the first sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr1fea2;
	/**
	 * represents the feature of the first sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr1fea3;
	/**
	 * represents the feature of the first sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr1fea4;
	/**
	 * represents the feature of the first sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr1fea5;
	/**
	 * represents the feature of the second sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr2fea1;
	/**
	 * represents the feature of the second sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr2fea2;
	/**
	 * represents the feature of the second sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr2fea3;
	/**
	 * represents the feature of the second sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr2fea4;
	/**
	 * represents the feature of the second sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr2fea5;
	/**
	 * represents the feature of the third sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr3fea1;
	/**
	 * represents the feature of the third sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr3fea2;
	/**
	 * represents the feature of the third sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr3fea3;
	/**
	 * represents the feature of the third sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr3fea4;
	/**
	 * represents the feature of the third sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr3fea5;
	/**
	 * represents the feature of the fourth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr4fea1;
	/**
	 * represents the feature of the fourth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr4fea2;
	/**
	 * represents the feature of the fourth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr4fea3;
	/**
	 * represents the feature of the fourth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr4fea4;
	/**
	 * represents the feature of the fourth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr4fea5;
	/**
	 * represents the feature of the fifth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr5fea1;
	/**
	 * represents the feature of the fifth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr5fea2;
	/**
	 * represents the feature of the fifth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr5fea3;
	/**
	 * represents the feature of the fifth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr5fea4;
	/**
	 * represents the feature of the fifth sprint of the first release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel1spr5fea5;
	/**
	 * represents the feature of the first sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr1fea1;
	/**
	 * represents the feature of the first sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr1fea2;
	/**
	 * represents the feature of the first sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr1fea3;
	/**
	 * represents the feature of the first sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr1fea4;
	/**
	 * represents the feature of the first sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr1fea5;
	/**
	 * represents the feature of the second sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr2fea1;
	/**
	 * represents the feature of the second sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr2fea2;
	/**
	 * represents the feature of the second sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr2fea3;
	/**
	 * represents the feature of the second sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr2fea4;
	/**
	 * represents the feature of the second sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr2fea5;
	/**
	 * represents the feature of the third sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr3fea1;
	/**
	 * represents the feature of the third sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr3fea2;
	/**
	 * represents the feature of the third sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr3fea3;
	/**
	 * represents the feature of the third sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr3fea4;
	/**
	 * represents the feature of the third sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr3fea5;
	/**
	 * represents the feature of the fourth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr4fea1;
	/**
	 * represents the feature of the fourth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr4fea2;
	/**
	 * represents the feature of the fourth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr4fea3;
	/**
	 * represents the feature of the fourth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr4fea4;
	/**
	 * represents the feature of the fourth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr4fea5;
	/**
	 * represents the feature of the fifth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr5fea1;
	/**
	 * represents the feature of the fifth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr5fea2;
	/**
	 * represents the feature of the fifth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr5fea3;
	/**
	 * represents the feature of the fifth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr5fea4;
	/**
	 * represents the feature of the fifth sprint of the second release of project two which is needed to test complex
	 * things.
	 */
	private Feature pro2rel2spr5fea5;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	private Role roleTSUser;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	private Role roleScrummaster;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	private Role roleProductOwner;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	private Role roleDeveloper;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	private Role roleTester;
	/**
	 * represents one role needed to test complex things in the IPScrum.
	 */
	private Role roleGUIWiz;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	private Person pSarah;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	private Person pWilken;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	private Person pChristin;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	private Person pBjoern;
	/**
	 * represents one person needed to test complex things in the IPScrum.
	 */
	private Person pChris;
	/**
	 * represents one team needed to test complex things in the IPScrum.
	 */
	private Team team1;
	/**
	 * represents one team needed to test complex things in the IPScrum.
	 */
	private Team team2;
	/**
	 * represents one team needed to test complex things in the IPScrum.
	 */
	private Team team3;
	/**
	 * represents one team needed to test complex things in the IPScrum.
	 */
	private Team team4;
	/**
	 * represents one project needed to test complex things in the IPScrum.
	 */
	private Project projekt1;
	/**
	 * represents one project needed to test complex things in the IPScrum.
	 */
	private Project projekt2;
	/**
	 * represents the first release of project one which is needed to test complex things in the IPScrum.
	 */
	private Release pro1rel1;
	/**
	 * represents the second release of project one which is needed to test complex things in the IPScrum.
	 */
	private Release pro1rel2;
	/**
	 * represents the first release of project two which is needed to test complex things in the IPScrum.
	 */
	private Release pro2rel1;
	/**
	 * represents the second release of project two which is needed to test complex things in the IPScrum.
	 */
	private Release pro2rel2;
	/**
	 * represents the first sprint of the first release of project one which is needed to test complex things in the
	 * IPScrum.
	 */
	private Sprint pro1rel1spr1;
	/**
	 * represents the second sprint of the first release of project one which is needed to test complex things in the
	 * IPScrum.
	 */
	private Sprint pro1rel1spr2;
	/**
	 * represents the third sprint of the first release of project one which is needed to test complex things in the
	 * IPScrum.
	 */
	private Sprint pro1rel1spr3;
	/**
	 * represents the fourth sprint of the first release of project one which is needed to test complex things in the
	 * IPScrum.
	 */
	private Sprint pro1rel1spr4;
	/**
	 * represents the fifth sprint of the first release of project one which is needed to test complex things in the
	 * IPScrum.
	 */
	private Sprint pro1rel1spr5;
	/**
	 * represents a sprint of the second release of project one which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro1rel2spr1;
	/**
	 * represents a sprint of the second release of project one which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro1rel2spr2;
	/**
	 * represents a sprint of the second release of project one which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro1rel2spr3;
	/**
	 * represents a sprint of the second release of project one which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro1rel2spr4;
	/**
	 * represents a sprint of the second release of project one which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro1rel2spr5;
	/**
	 * represents a sprint of the first release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel1spr1;
	/**
	 * represents a sprint of the first release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel1spr2;
	/**
	 * represents a sprint of the first release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel1spr3;
	/**
	 * represents a sprint of the first release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel1spr4;
	/**
	 * represents a sprint of the first release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel1spr5;
	/**
	 * represents a sprint of the second release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel2spr1;
	/**
	 * represents a sprint of the second release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel2spr2;
	/**
	 * represents a sprint of the second release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel2spr3;
	/**
	 * represents a sprint of the second release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel2spr4;
	/**
	 * represents a sprint of the second release of project two which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro2rel2spr5;
	/**
	 * represents a task of the first sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr1tas1;
	/**
	 * represents a task of the first sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr1tas2;
	/**
	 * represents a task of the first sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr1tas3;
	/**
	 * represents a task of the first sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr1tas4;
	/**
	 * represents a task of the first sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr1tas5;
	/**
	 * represents a task of the second sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr2tas1;
	/**
	 * represents a task of the second sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr2tas2;
	/**
	 * represents a task of the second sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr2tas3;
	/**
	 * represents a task of the second sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr2tas4;
	/**
	 * represents a task of the second sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr2tas5;
	/**
	 * represents a task of the third sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr3tas1;
	/**
	 * represents a task of the third sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr3tas2;
	/**
	 * represents a task of the third sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr3tas3;
	/**
	 * represents a task of the third sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr3tas4;
	/**
	 * represents a task of the third sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr3tas5;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr4tas1;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr4tas2;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr4tas3;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr4tas4;
	/**
	 * represents a task of the fourth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr4tas5;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr5tas1;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr5tas2;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr5tas3;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr5tas4;
	/**
	 * represents a task of the fifth sprint of the first release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel1spr5tas5;
	/**
	 * represents a task of the first sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr1tas1;
	/**
	 * represents a task of the first sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr1tas2;
	/**
	 * represents a task of the first sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr1tas3;
	/**
	 * represents a task of the first sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr1tas4;
	/**
	 * represents a task of the first sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr1tas5;
	/**
	 * represents a task of the second sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr2tas1;
	/**
	 * represents a task of the second sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr2tas2;
	/**
	 * represents a task of the second sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr2tas3;
	/**
	 * represents a task of the second sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr2tas4;
	/**
	 * represents a task of the second sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr2tas5;
	/**
	 * represents a task of the third sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr3tas1;
	/**
	 * represents a task of the third sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr3tas2;
	/**
	 * represents a task of the third sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr3tas3;
	/**
	 * represents a task of the third sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr3tas4;
	/**
	 * represents a task of the third sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr3tas5;
	/**
	 * represents a task of the fourth sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr4tas1;
	/**
	 * represents a task of the fourth sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr4tas2;
	/**
	 * represents a task of the fourth sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr4tas3;
	/**
	 * represents a task of the fourth sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr4tas4;
	/**
	 * represents a task of the fourth sprint of the second release of project one which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro1rel2spr4tas5;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr5tas1;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr5tas2;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr5tas3;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr5tas4;
	/**
	 * represents a task of the fifth sprint of the second release of project one which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro1rel2spr5tas5;
	/**
	 * represents a task of the first sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr1tas1;
	/**
	 * represents a task of the first sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr1tas2;
	/**
	 * represents a task of the first sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr1tas3;
	/**
	 * represents a task of the first sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr1tas4;
	/**
	 * represents a task of the first sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr1tas5;
	/**
	 * represents a task of the second sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr2tas1;
	/**
	 * represents a task of the second sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr2tas2;
	/**
	 * represents a task of the second sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr2tas3;
	/**
	 * represents a task of the second sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr2tas4;
	/**
	 * represents a task of the second sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr2tas5;
	/**
	 * represents a task of the third sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr3tas1;
	/**
	 * represents a task of the third sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr3tas2;
	/**
	 * represents a task of the third sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr3tas3;
	/**
	 * represents a task of the third sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr3tas4;
	/**
	 * represents a task of the third sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr3tas5;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr4tas1;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr4tas2;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr4tas3;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr4tas4;
	/**
	 * represents a task of the fourth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr4tas5;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr5tas2;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr5tas3;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr5tas4;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr5tas5;
	/**
	 * represents a task of the first sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr1tas1;
	/**
	 * represents a task of the first sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr1tas2;
	/**
	 * represents a task of the first sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr1tas3;
	/**
	 * represents a task of the first sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr1tas4;
	/**
	 * represents a task of the first sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr1tas5;
	/**
	 * represents a task of the second sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr2tas1;
	/**
	 * represents a task of the second sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr2tas2;
	/**
	 * represents a task of the second sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr2tas3;
	/**
	 * represents a task of the second sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr2tas4;
	/**
	 * represents a task of the second sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr2tas5;
	/**
	 * represents a task of the third sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr3tas1;
	/**
	 * represents a task of the third sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr3tas2;
	/**
	 * represents a task of the third sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr3tas3;
	/**
	 * represents a task of the third sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr3tas4;
	/**
	 * represents a task of the third sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr3tas5;
	/**
	 * represents a task of the fourth sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr4tas2;
	/**
	 * represents a task of the fourth sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr4tas1;
	/**
	 * represents a task of the fourth sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr4tas3;
	/**
	 * represents a task of the fourth sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr4tas4;
	/**
	 * represents a task of the fourth sprint of the second release of project two which is needed to test complex
	 * things in the IPScrum.
	 */
	private Task pro2rel2spr4tas5;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr5tas1;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr5tas2;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr5tas3;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr5tas4;
	/**
	 * represents a task of the fifth sprint of the second release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel2spr5tas5;
	/**
	 * represents a task of the fifth sprint of the first release of project two which is needed to test complex things
	 * in the IPScrum.
	 */
	private Task pro2rel1spr5tas1;
	/**
	 * represents a project which is needed to test complex things in the IPScrum.
	 */
	private Project projekt3;
	/**
	 * represents the first release of project three which is needed to test complex things in the IPScrum.
	 */
	private Release pro3rel1;
	/**
	 * represents the second release of project three which is needed to test complex things in the IPScrum.
	 */
	private Release pro3rel2;
	/**
	 * represents a sprint of the first release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel1spr1;
	/**
	 * represents a sprint of the first release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel1spr2;
	/**
	 * represents a sprint of the first release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel1spr3;
	/**
	 * represents a sprint of the first release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel1spr4;
	/**
	 * represents a sprint of the first release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel1spr5;
	/**
	 * represents a sprint of the second release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel2spr1;
	/**
	 * represents a sprint of the second release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel2spr2;
	/**
	 * represents a sprint of the second release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel2spr3;
	/**
	 * represents a sprint of the second release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel2spr4;
	/**
	 * represents a sprint of the second release of project three which is needed to test complex things in the IPScrum.
	 */
	private Sprint pro3rel2spr5;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel1spr1fea1;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr1fea2;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr1fea3;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr1fea4;
	/**
	 * represents a bug/feature of the first sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr1fea5;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr2fea1;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr2fea2;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel1spr2fea3;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel1spr2fea4;
	/**
	 * represents a bug/feature of the second sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr2fea5;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr3fea1;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr3fea2;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel1spr3fea3;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr3fea4;
	/**
	 * represents a bug/feature of the third sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr3fea5;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel1spr4fea1;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr4fea2;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr4fea3;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr4fea4;
	/**
	 * represents a bug/feature of the fourth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr4fea5;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel1spr5fea1;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr5fea2;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel1spr5fea3;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel1spr5fea4;
	/**
	 * represents a bug/feature of the fifth sprint of the first release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel1spr5fea5;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr1fea1;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr1fea2;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr1fea3;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr1fea4;
	/**
	 * represents a bug/feature of the first sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr1fea5;
	/**
	 * represents a bug/feature of the second sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr2fea1;
	/**
	 * represents a bug/feature of the second sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr2fea2;
	/**
	 * represents a bug/feature of the second sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr2fea3;
	/**
	 * represents a bug/feature of the second sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr2fea4;
	/**
	 * represents a bug/feature of the second sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr2fea5;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr3fea1;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr3fea2;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr3fea3;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr3fea4;
	/**
	 * represents a bug/feature of the third sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr3fea5;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr4fea1;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr4fea2;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr4fea3;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr4fea4;
	/**
	 * represents a bug/feature of the fourth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Feature pro3rel2spr4fea5;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr5fea1;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr5fea2;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr5fea3;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr5fea4;
	/**
	 * represents a bug/feature of the fifth sprint of the second release of project three which is needed to test
	 * complex things in the IPScrum.
	 */
	private Bug pro3rel2spr5fea5;
	/**
	 * represents a list of feature which is needed to test complex things in the IPScrum.
	 */
	private Collection<ProductBacklogItem> listOfFeatures;

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
		this.setModel(ServerContext.getInstance().getPersistenceManager().getCurrentModel());
		this.getModel().setUuidManager(new IDGenerator());
		new RelationType(this.getModel(), "Abhängig von");
		new RelationType(this.getModel(), "Siehe auch");

		this.setRoleTSUser(new Role(this.getModel(), "Ticketsystem-Benutzer"));

		this.setRoleScrummaster(new Role(this.getModel(), "Scrum-Master"));
		this.setRoleProductOwner(new Role(this.getModel(), "Product-Owner"));
		this.setRoleDeveloper(new Role(this.getModel(), "Entwickler"));
		this.setRoleTester(new Role(this.getModel(), "Tester"));
		this.setRoleGUIWiz(new Role(this.getModel(), "GUI-Wizard"));

		// Initial Persons
		this.setpSarah(new Person(this.getModel(), "Sarah", "Gottwald"));
		this.getpSarah().addRole(this.getRoleScrummaster());
		this.getpSarah().addRole(this.getRoleTSUser());

		this.setpWilken(new Person(this.getModel(), "Wilken", "Hustedt"));
		this.getpWilken().addRole(this.getRoleDeveloper());
		this.getpWilken().addRole(this.getRoleGUIWiz());
		this.getpWilken().addRole(this.getRoleTSUser());

		this.setpChristin(new Person(this.getModel(), "Christin", "Weckbrod"));
		this.getpChristin().addRole(this.getRoleProductOwner());
		this.getpChristin().addRole(this.getRoleDeveloper());
		this.getpChristin().addRole(this.getRoleTSUser());

		this.setpBjoern(new Person(this.getModel(), "Björn", "Bodensieck"));
		this.getpBjoern().addRole(this.getRoleTester());
		this.getpBjoern().addRole(this.getRoleTSUser());

		this.setpChris(new Person(this.getModel(), "Christoph", "Stürzekarn"));
		this.getpChris().addRole(this.getRoleTester());
		this.getpChris().addRole(this.getRoleDeveloper());
		this.getpChris().addRole(this.getRoleTSUser());

		// Initial Teams
		this.setTeam1(new Team(this.getModel(), "Frontend"));
		this.getTeam1().addMember(this.getpSarah());
		this.getTeam1().addMember(this.getpWilken());
		this.getTeam1().addMember(this.getpBjoern());

		this.setTeam2(new Team(this.getModel(), "Backend"));
		this.getTeam2().addMember(this.getpChristin());

		this.setTeam3(new Team(this.getModel(), "Reporting"));
		this.getTeam3().addMember(this.getpChris());
		this.getTeam3().addMember(this.getpSarah());
		this.getTeam3().addMember(this.getpWilken());

		this.setTeam4(new Team(this.getModel(), "Testing"));
		this.getTeam4().addMember(this.getpChris());
		this.getTeam4().addMember(this.getpBjoern());

		// Initial Projects
		this.setProjekt1(new Project(this.getModel(), "Projekt 1"));
		this.setProjekt2(new Project(this.getModel(), "Projekt 2"));
		this.setProjekt3(new Project(this.getModel(), "Projekt 3"));

		this.getTeam1().addProject(this.getProjekt1());
		this.getTeam1().addProject(this.getProjekt2());
		this.getTeam1().addProject(this.getProjekt3());
		this.getTeam2().addProject(this.getProjekt1());
		this.getTeam2().addProject(this.getProjekt2());
		this.getTeam2().addProject(this.getProjekt3());
		this.getTeam3().addProject(this.getProjekt1());
		this.getTeam3().addProject(this.getProjekt2());
		this.getTeam3().addProject(this.getProjekt3());
		this.getTeam4().addProject(this.getProjekt1());
		this.getTeam4().addProject(this.getProjekt2());
		this.getTeam4().addProject(this.getProjekt3());

		// Initial Releases
		this.setPro1rel1(new Release(this.getModel(), "1.0", CalendarUtils.getRandomReleaseDate(), this.getProjekt1()));
		this.setPro1rel2(new Release(this.getModel(), "2.0", CalendarUtils.getRandomReleaseDate(), this.getProjekt1()));
		this.setPro2rel1(new Release(this.getModel(), "1.0", CalendarUtils.getRandomReleaseDate(), this.getProjekt2()));
		this.setPro2rel2(new Release(this.getModel(), "2.0", CalendarUtils.getRandomReleaseDate(), this.getProjekt2()));
		this.setPro3rel1(new Release(this.getModel(), "1.0", CalendarUtils.getRandomReleaseDate(), this.getProjekt3()));
		this.setPro3rel2(new Release(this.getModel(), "2.0", CalendarUtils.getRandomReleaseDate(), this.getProjekt3()));

		// Initial Sprints
		// Für Projekt 1, Release 1
		// final Date pro1rel1spr1BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr1EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr1BeginDate, this.pro1rel1.getReleaseDate());
		this.setPro1rel1spr1(new Sprint(this.getModel(), "Pro1Rel1Sprint1", "Beschreibung Sprint 1", new Date(
				2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 2 - 1, 28), this.getTeam1(), this.getProjekt1()));

		// final Date pro1rel1spr2BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr2EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr2BeginDate, this.pro1rel1.getReleaseDate());
		this.setPro1rel1spr2(new Sprint(this.getModel(), "Pro1Rel1Sprint2", "Beschreibung Sprint 2", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt1()));

		// final Date pro1rel1spr3BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr3EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr3BeginDate, this.pro1rel1.getReleaseDate());
		this.setPro1rel1spr3(new Sprint(this.getModel(), "Pro1Rel1Sprint3", "Beschreibung Sprint 3", new Date(
				2011 - 1900, 1 - 1, 1), new Date(2011 - 1900, 1 - 1, 31), this.getTeam1(), this.getProjekt1()));

		// final Date pro1rel1spr4BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr4EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr4BeginDate, this.pro1rel1.getReleaseDate());
		this.setPro1rel1spr4(new Sprint(this.getModel(), "Pro1Rel1Sprint4", "Beschreibung Sprint 4", new Date(
				2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt1()));

		// final Date pro1rel1spr5BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel1spr5EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel1spr5BeginDate, this.pro1rel1.getReleaseDate());
		this.setPro1rel1spr5(new Sprint(this.getModel(), "Pro1Rel1Sprint5", "Beschreibung Sprint 5", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt1()));

		// Für Projekt 1, Release 2
		// final Date pro1rel2spr1BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel2spr1EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel2spr1BeginDate, this.pro1rel2.getReleaseDate());
		this.setPro1rel2spr1(new Sprint(this.getModel(), "Pro1Rel2Sprint1", "Beschreibung Sprint 1", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt1()));

		// final Date pro1rel2spr2BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro1rel2spr2EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro1rel2spr2BeginDate, this.pro1rel2.getReleaseDate());
		this.setPro1rel2spr2(new Sprint(this.getModel(), "Pro1Rel2Sprint2", "Beschreibung Sprint 2", new Date(
				2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt1()));

		final Date pro1rel2spr3BeginDate = new Date();
		final Date pro1rel2spr3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(pro1rel2spr3EndDate, 4);
		this.setPro1rel2spr3(new Sprint(this.getModel(), "Pro1Rel2Sprint3", "Beschreibung Sprint 3", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt1()));

		final Date pro1rel2spr4BeginDate = new Date();
		final Date pro1rel2spr4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(pro1rel2spr4EndDate, 1);
		this.setPro1rel2spr4(new Sprint(this.getModel(), "Pro1Rel2Sprint4", "Beschreibung Sprint 4", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt1()));

		final Date pro1rel2spr5BeginDate = new Date();
		final Date pro1rel2spr5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(pro1rel2spr5EndDate, 4);
		this.setPro1rel2spr5(new Sprint(this.getModel(), "Pro1Rel2Sprint5", "Beschreibung Sprint 5", new Date(
				2011 - 1900, 4 - 1, 1), new Date(2011 - 1900, 4 - 1, 30), this.getTeam1(), this.getProjekt1()));

		// Für Projekt 2, Release 1
		// final Date pro2rel1spr1BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro2rel1spr1EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro2rel1spr1BeginDate, this.pro2rel1.getReleaseDate());
		this.setPro2rel1spr1(new Sprint(this.getModel(), "Pro2Rel1Sprint1", "Beschreibung Sprint 1", new Date(
				2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 4 - 1, 30), this.getTeam1(), this.getProjekt2()));

		// final Date pro2rel1spr2BeginDate = CalendarUtils
		// .getRandomDateOfThisMonth();
		// final Date pro2rel1spr2EndDate =
		// CalendarUtils.getRandomSprintEnddate(
		// pro2rel1spr2BeginDate, this.pro2rel1.getReleaseDate());
		this.setPro2rel1spr2(new Sprint(this.getModel(), "Pro2Rel1Sprint2", "Beschreibung Sprint 2", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt2()));

		final Date pro2rel1spr3BeginDate = new Date();
		final Date pro2rel1spr3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(pro2rel1spr3EndDate, 4);
		this.setPro2rel1spr3(new Sprint(this.getModel(), "Pro2Rel1Sprint3", "Beschreibung Sprint 3", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 4 - 1, 30), this.getTeam1(), this.getProjekt2()));

		final Date pro2rel1spr4BeginDate = new Date();
		final Date pro2rel1spr4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(pro2rel1spr4EndDate, 1);
		this.setPro2rel1spr4(new Sprint(this.getModel(), "Pro2Rel1Sprint4", "Beschreibung Sprint 4", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt2()));

		final Date pro2rel1spr5BeginDate = new Date();
		final Date pro2rel1spr5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(pro2rel1spr5EndDate, 4);
		this.setPro2rel1spr5(new Sprint(this.getModel(), "Pro2Rel1Sprint5", "Beschreibung Sprint 5", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt2()));

		// Für Projekt 2, Release 2
		// final Date sprint6BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint6EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint6BeginDate, this.pro2rel2.getReleaseDate());
		this.setPro2rel2spr1(new Sprint(this.getModel(), "Pro2Rel2Sprint1", "Beschreibung Sprint 1", new Date(
				2011 - 1900, 6 - 1, 1), new Date(2011 - 1900, 6 - 1, 30), this.getTeam1(), this.getProjekt2()));

		// final Date sprint7BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint7EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint7BeginDate, this.pro2rel2.getReleaseDate());
		this.setPro2rel2spr2(new Sprint(this.getModel(), "Pro2Rel2Sprint2", "Beschreibung Sprint 2", new Date(
				2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt2()));

		// final Date sprint8BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint8EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint8BeginDate, this.pro2rel2.getReleaseDate());
		this.setPro2rel2spr3(new Sprint(this.getModel(), "Pro2Rel2Sprint3", "Beschreibung Sprint 3", new Date(
				2011 - 1900, 1 - 1, 1), new Date(2011 - 1900, 1 - 1, 31), this.getTeam1(), this.getProjekt2()));

		// final Date sprint9BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint9EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint9BeginDate, this.pro2rel2.getReleaseDate());
		this.setPro2rel2spr4(new Sprint(this.getModel(), "Pro2Rel2Sprint4", "Beschreibung Sprint 4", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt2()));

		// final Date sprint10BeginDate =
		// CalendarUtils.getRandomDateOfThisMonth();
		// final Date sprint10EndDate = CalendarUtils.getRandomSprintEnddate(
		// sprint10BeginDate, this.pro2rel2.getReleaseDate());
		this.setPro2rel2spr5(new Sprint(this.getModel(), "Pro2Rel2Sprint5", "Beschreibung Sprint 5", new Date(
				2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam1(), this.getProjekt2()));

		// Für Projekt 3, Release 1
		this.setPro3rel1spr1(new Sprint(this.getModel(), "Pro3Rel1Sprint1", "Beschreibung Sprint 1", new Date(
				2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 2 - 1, 28), this.getTeam4(), this.getProjekt3()));
		this.setPro3rel1spr2(new Sprint(this.getModel(), "Pro3Rel1Sprint2", "Beschreibung Sprint 2", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam4(), this.getProjekt3()));
		this.setPro3rel1spr3(new Sprint(this.getModel(), "Pro3Rel1Sprint3", "Beschreibung Sprint 3", new Date(
				2011 - 1900, 1 - 1, 1), new Date(2011 - 1900, 1 - 1, 31), this.getTeam4(), this.getProjekt3()));
		this.setPro3rel1spr4(new Sprint(this.getModel(), "Pro3Rel1Sprint4", "Beschreibung Sprint 4", new Date(
				2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam4(), this.getProjekt3()));
		this.setPro3rel1spr5(new Sprint(this.getModel(), "Pro3Rel1Sprint5", "Beschreibung Sprint 5", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam4(), this.getProjekt3()));

		// Für Projekt 3, Release 2
		this.setPro3rel2spr1(new Sprint(this.getModel(), "Pro3Rel2Sprint1", "Beschreibung Sprint 1", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam4(), this.getProjekt3()));
		this.setPro3rel2spr2(new Sprint(this.getModel(), "Pro3Rel2Sprint2", "Beschreibung Sprint 2", new Date(
				2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam4(), this.getProjekt3()));
		this.setPro3rel2spr3(new Sprint(this.getModel(), "Pro3Rel2Sprint3", "Beschreibung Sprint 3", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam4(), this.getProjekt3()));
		this.setPro3rel2spr4(new Sprint(this.getModel(), "Pro3Rel2Sprint4", "Beschreibung Sprint 4", new Date(
				2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1, 31), this.getTeam4(), this.getProjekt3()));
		this.setPro3rel2spr5(new Sprint(this.getModel(), "Pro3Rel2Sprint5", "Beschreibung Sprint 5", new Date(
				2011 - 1900, 4 - 1, 1), new Date(2011 - 1900, 4 - 1, 30), this.getTeam4(), this.getProjekt3()));

		// Initial Features
		// für Projekt 1, Release 1, Sprint 1
		final FeatureTicketType featureTicketType = this.getModel().getTypeManager().getStandardFeatureType();
		final StateType closedState = this.getModel().getTypeManager().getClosed();
		final BugTicketType bugTicketType = this.getModel().getTypeManager().getStandardBugType();
		this.setPro1rel1spr1fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 1, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr1fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr1fea1().setManDayCosts(new Effort(3));
		this.getPro1rel1spr1fea1().setSprint(this.getPro1rel1spr1());
		this.getPro1rel1spr1fea1().changeState(closedState);

		this.setPro1rel1spr1fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 1, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr1fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr1fea2().setManDayCosts(new Effort(4));
		this.getPro1rel1spr1fea2().setSprint(this.getPro1rel1spr1());
		this.getPro1rel1spr1fea2().changeState(closedState);

		this.setPro1rel1spr1fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 1, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr1fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr1fea3().setManDayCosts(new Effort(5));
		this.getPro1rel1spr1fea3().setSprint(this.getPro1rel1spr1());
		// pro1rel1spr1fea3.changeState(closedState);

		this.setPro1rel1spr1fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 1, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr1fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr1fea4().setManDayCosts(new Effort(4));
		this.getPro1rel1spr1fea4().setSprint(this.getPro1rel1spr1());
		// pro1rel1spr1fea4.changeState(closedState);

		this.setPro1rel1spr1fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 1, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr1fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr1fea5().setManDayCosts(new Effort(3));
		this.getPro1rel1spr1fea5().setSprint(this.getPro1rel1spr1());
		this.getPro1rel1spr1fea5().changeState(closedState);

		// für Projekt 1, Release 1, Sprint 2
		this.setPro1rel1spr2fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 2, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr2fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr2fea1().setManDayCosts(new Effort(2));
		this.getPro1rel1spr2fea1().setSprint(this.getPro1rel1spr2());
		this.getPro1rel1spr2fea1().changeState(closedState);

		this.setPro1rel1spr2fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 2, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr2fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr2fea2().setManDayCosts(new Effort(10));
		this.getPro1rel1spr2fea2().setSprint(this.getPro1rel1spr2());
		// pro1rel1spr2fea2.changeState(closedState);

		this.setPro1rel1spr2fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 2, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr2fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr2fea3().setManDayCosts(new Effort(15));
		this.getPro1rel1spr2fea3().setSprint(this.getPro1rel1spr2());
		this.getPro1rel1spr2fea3().changeState(closedState);

		this.setPro1rel1spr2fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 2, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr2fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr2fea4().setManDayCosts(new Effort(3));
		this.getPro1rel1spr2fea4().setSprint(this.getPro1rel1spr2());
		this.getPro1rel1spr2fea4().changeState(closedState);

		this.setPro1rel1spr2fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 2, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr2fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr2fea5().setManDayCosts(new Effort(6));
		this.getPro1rel1spr2fea5().setSprint(this.getPro1rel1spr2());
		// pro1rel1spr2fea5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 3
		this.setPro1rel1spr3fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 3, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr3fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr3fea1().setManDayCosts(new Effort(20));
		this.getPro1rel1spr3fea1().setSprint(this.getPro1rel1spr3());
		// pro1rel1spr3fea1.changeState(closedState);

		this.setPro1rel1spr3fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 3, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr3fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr3fea2().setManDayCosts(new Effort(6));
		this.getPro1rel1spr3fea2().setSprint(this.getPro1rel1spr3());
		// pro1rel1spr3fea2.changeState(closedState);

		this.setPro1rel1spr3fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 3, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr3fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr3fea3().setManDayCosts(new Effort(48));
		this.getPro1rel1spr3fea3().setSprint(this.getPro1rel1spr3());
		this.getPro1rel1spr3fea3().changeState(closedState);

		this.setPro1rel1spr3fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 3, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr3fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr3fea4().setManDayCosts(new Effort(2));
		this.getPro1rel1spr3fea4().setSprint(this.getPro1rel1spr3());
		this.getPro1rel1spr3fea4().changeState(closedState);

		this.setPro1rel1spr3fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 3, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr3fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr3fea5().setManDayCosts(new Effort(1));
		this.getPro1rel1spr3fea5().setSprint(this.getPro1rel1spr3());
		// pro1rel1spr3fea5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 4
		this.setPro1rel1spr4fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 4, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr4fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr4fea1().setManDayCosts(new Effort(4));
		this.getPro1rel1spr4fea1().setSprint(this.getPro1rel1spr4());
		// pro1rel1spr4fea1.changeState(closedState);

		this.setPro1rel1spr4fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 4, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr4fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr4fea2().setManDayCosts(new Effort(10));
		this.getPro1rel1spr4fea2().setSprint(this.getPro1rel1spr4());
		// pro1rel1spr4fea2.changeState(closedState);

		this.setPro1rel1spr4fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 4, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr4fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr4fea3().setManDayCosts(new Effort(5));
		this.getPro1rel1spr4fea3().setSprint(this.getPro1rel1spr4());
		// pro1rel1spr4fea3.changeState(closedState);

		this.setPro1rel1spr4fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 4, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr4fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr4fea4().setManDayCosts(new Effort(9));
		this.getPro1rel1spr4fea4().setSprint(this.getPro1rel1spr4());
		// pro1rel1spr4fea4.changeState(closedState);

		this.setPro1rel1spr4fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 4, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr4fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr4fea5().setManDayCosts(new Effort(3));
		this.getPro1rel1spr4fea5().setSprint(this.getPro1rel1spr4());
		// pro1rel1spr4fea5.changeState(closedState);

		// für Projekt 1, Release 1, Sprint 5
		this.setPro1rel1spr5fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 5, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr5fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr5fea1().setManDayCosts(new Effort(16));
		this.getPro1rel1spr5fea1().setSprint(this.getPro1rel1spr5());
		this.getPro1rel1spr5fea1().changeState(closedState);

		this.setPro1rel1spr5fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 5, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr5fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr5fea2().setManDayCosts(new Effort(4));
		this.getPro1rel1spr5fea2().setSprint(this.getPro1rel1spr5());
		this.getPro1rel1spr5fea2().changeState(closedState);

		this.setPro1rel1spr5fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 5, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr5fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr5fea3().setManDayCosts(new Effort(5));
		this.getPro1rel1spr5fea3().setSprint(this.getPro1rel1spr5());
		this.getPro1rel1spr5fea3().changeState(closedState);

		this.setPro1rel1spr5fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 5, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr5fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr5fea4().setManDayCosts(new Effort(35));
		this.getPro1rel1spr5fea4().setSprint(this.getPro1rel1spr5());
		this.getPro1rel1spr5fea4().changeState(closedState);

		this.setPro1rel1spr5fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 1, Sprint 5, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel1spr5fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel1spr5fea5().setManDayCosts(new Effort(3));
		this.getPro1rel1spr5fea5().setSprint(this.getPro1rel1spr5());
		this.getPro1rel1spr5fea5().changeState(closedState);

		// für Projekt 1, Release 2, Sprint 1
		this.setPro1rel2spr1fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 1, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr1fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr1fea1().setManDayCosts(new Effort(80));
		this.getPro1rel2spr1fea1().setSprint(this.getPro1rel2spr1());
		this.getPro1rel2spr1fea1().changeState(closedState);

		this.setPro1rel2spr1fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 1, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr1fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr1fea2().setManDayCosts(new Effort(20));
		this.getPro1rel2spr1fea2().setSprint(this.getPro1rel2spr1());
		// pro1rel2spr1fea2.changeState(closedState);

		this.setPro1rel2spr1fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 1, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr1fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr1fea3().setManDayCosts(new Effort(5));
		this.getPro1rel2spr1fea3().setSprint(this.getPro1rel2spr1());
		this.getPro1rel2spr1fea3().changeState(closedState);

		this.setPro1rel2spr1fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 1, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr1fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr1fea4().setManDayCosts(new Effort(4));
		this.getPro1rel2spr1fea4().setSprint(this.getPro1rel2spr1());
		this.getPro1rel2spr1fea4().changeState(closedState);

		this.setPro1rel2spr1fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 1, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr1fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr1fea5().setManDayCosts(new Effort(3));
		this.getPro1rel2spr1fea5().setSprint(this.getPro1rel2spr1());
		this.getPro1rel2spr1fea5().changeState(closedState);

		// für Projekt 1, Release 2, Sprint 2
		this.setPro1rel2spr2fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 2, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr2fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr2fea1().setManDayCosts(new Effort(5));
		this.getPro1rel2spr2fea1().setSprint(this.getPro1rel2spr2());
		// pro1rel2spr2fea1.changeState(closedState);

		this.setPro1rel2spr2fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 2, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr2fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr2fea2().setManDayCosts(new Effort(20));
		this.getPro1rel2spr2fea2().setSprint(this.getPro1rel2spr2());
		// pro1rel2spr2fea2.changeState(closedState);

		this.setPro1rel2spr2fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 2, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr2fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr2fea3().setManDayCosts(new Effort(5));
		this.getPro1rel2spr2fea3().setSprint(this.getPro1rel2spr2());
		// pro1rel2spr2fea3.changeState(closedState);

		this.setPro1rel2spr2fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 2, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr2fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr2fea4().setManDayCosts(new Effort(6));
		this.getPro1rel2spr2fea4().setSprint(this.getPro1rel2spr2());
		this.getPro1rel2spr2fea4().changeState(closedState);

		this.setPro1rel2spr2fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 2, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr2fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr2fea5().setManDayCosts(new Effort(35));
		this.getPro1rel2spr2fea5().setSprint(this.getPro1rel2spr2());
		this.getPro1rel2spr2fea5().changeState(closedState);

		// für Projekt 1, Release 2, Sprint 3
		this.setPro1rel2spr3fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 3, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr3fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr3fea1().setManDayCosts(new Effort(13));
		this.getPro1rel2spr3fea1().setSprint(this.getPro1rel2spr3());
		this.getPro1rel2spr3fea1().changeState(closedState);

		this.setPro1rel2spr3fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 3, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr3fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr3fea2().setManDayCosts(new Effort(7));
		this.getPro1rel2spr3fea2().setSprint(this.getPro1rel2spr3());
		this.getPro1rel2spr3fea2().changeState(closedState);

		this.setPro1rel2spr3fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 3, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr3fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr3fea3().setManDayCosts(new Effort(100));
		this.getPro1rel2spr3fea3().setSprint(this.getPro1rel2spr3());
		// pro1rel2spr3fea3.changeState(closedState);

		this.setPro1rel2spr3fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 3, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr3fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr3fea4().setManDayCosts(new Effort(83));
		this.getPro1rel2spr3fea4().setSprint(this.getPro1rel2spr3());
		this.getPro1rel2spr3fea4().changeState(closedState);

		this.setPro1rel2spr3fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 3, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr3fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr3fea5().setManDayCosts(new Effort(3));
		this.getPro1rel2spr3fea5().setSprint(this.getPro1rel2spr3());
		// pro1rel2spr3fea5.changeState(closedState);

		// für Projekt 1, Release 2, Sprint 4
		this.setPro1rel2spr4fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 4, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr4fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr4fea1().setManDayCosts(new Effort(20));
		this.getPro1rel2spr4fea1().setSprint(this.getPro1rel2spr4());
		this.getPro1rel2spr4fea1().changeState(closedState);

		this.setPro1rel2spr4fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 4, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr4fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr4fea2().setManDayCosts(new Effort(14));
		this.getPro1rel2spr4fea2().setSprint(this.getPro1rel2spr4());
		// pro1rel2spr4fea2.changeState(closedState);

		this.setPro1rel2spr4fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 4, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr4fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr4fea3().setManDayCosts(new Effort(80));
		this.getPro1rel2spr4fea3().setSprint(this.getPro1rel2spr4());
		this.getPro1rel2spr4fea3().changeState(closedState);

		this.setPro1rel2spr4fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 4, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr4fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr4fea4().setManDayCosts(new Effort(12));
		this.getPro1rel2spr4fea4().setSprint(this.getPro1rel2spr4());
		// pro1rel2spr4fea4.changeState(closedState);

		this.setPro1rel2spr4fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 4, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr4fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr4fea5().setManDayCosts(new Effort(16));
		this.getPro1rel2spr4fea5().setSprint(this.getPro1rel2spr4());
		this.getPro1rel2spr4fea5().changeState(closedState);

		// für Projekt 1, Release 2, Sprint 5
		this.setPro1rel2spr5fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 5, Feature 1", "Beschreibung Feature 1", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr5fea1().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr5fea1().setManDayCosts(new Effort(13));
		this.getPro1rel2spr5fea1().setSprint(this.getPro1rel2spr5());
		// pro1rel2spr5fea1.changeState(closedState);

		this.setPro1rel2spr5fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 5, Feature 2", "Beschreibung Feature 2", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr5fea2().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr5fea2().setManDayCosts(new Effort(14));
		this.getPro1rel2spr5fea2().setSprint(this.getPro1rel2spr5());
		this.getPro1rel2spr5fea2().changeState(closedState);

		this.setPro1rel2spr5fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 5, Feature 3", "Beschreibung Feature 3", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr5fea3().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr5fea3().setManDayCosts(new Effort(5));
		this.getPro1rel2spr5fea3().setSprint(this.getPro1rel2spr5());
		this.getPro1rel2spr5fea3().changeState(closedState);

		this.setPro1rel2spr5fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 5, Feature 4", "Beschreibung Feature 4", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr5fea4().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr5fea4().setManDayCosts(new Effort(4));
		this.getPro1rel2spr5fea4().setSprint(this.getPro1rel2spr5());
		// pro1rel2spr5fea4.changeState(closedState);

		this.setPro1rel2spr5fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 1, Release 2, Sprint 5, Feature 5", "Beschreibung Feature 5", this.getProjekt1().getBacklog()));
		this.getPro1rel2spr5fea5().setLastEditor(this.getpBjoern());
		this.getPro1rel2spr5fea5().setManDayCosts(new Effort(3));
		this.getPro1rel2spr5fea5().setSprint(this.getPro1rel2spr5());
		this.getPro1rel2spr5fea5().changeState(closedState);

		// für Projekt 2, Release 1, Sprint 1
		this.setPro2rel1spr1fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 1, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr1fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr1fea1().setManDayCosts(new Effort(3));
		this.getPro2rel1spr1fea1().setSprint(this.getPro2rel1spr1());
		// pro2rel1spr1fea1.changeState(closedState);

		this.setPro2rel1spr1fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 1, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr1fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr1fea2().setManDayCosts(new Effort(4));
		this.getPro2rel1spr1fea2().setSprint(this.getPro2rel1spr1());
		this.getPro2rel1spr1fea2().changeState(closedState);

		this.setPro2rel1spr1fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 1, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr1fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr1fea3().setManDayCosts(new Effort(5));
		this.getPro2rel1spr1fea3().setSprint(this.getPro2rel1spr1());
		this.getPro2rel1spr1fea3().changeState(closedState);

		this.setPro2rel1spr1fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 1, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr1fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr1fea4().setManDayCosts(new Effort(4));
		this.getPro2rel1spr1fea4().setSprint(this.getPro2rel1spr1());
		this.getPro2rel1spr1fea4().changeState(closedState);

		this.setPro2rel1spr1fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 1, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr1fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr1fea5().setManDayCosts(new Effort(3));
		this.getPro2rel1spr1fea5().setSprint(this.getPro2rel1spr1());
		this.getPro2rel1spr1fea5().changeState(closedState);

		// für Projekt 2, Release 1, Sprint 2
		this.setPro2rel1spr2fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 2, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr2fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr2fea1().setManDayCosts(new Effort(3));
		this.getPro2rel1spr2fea1().setSprint(this.getPro2rel1spr2());
		// pro2rel1spr2fea1.changeState(closedState);

		this.setPro2rel1spr2fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 2, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr2fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr2fea2().setManDayCosts(new Effort(4));
		this.getPro2rel1spr2fea2().setSprint(this.getPro2rel1spr2());
		// pro2rel1spr2fea2.changeState(closedState);

		this.setPro2rel1spr2fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 2, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr2fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr2fea3().setManDayCosts(new Effort(5));
		this.getPro2rel1spr2fea3().setSprint(this.getPro2rel1spr2());
		this.getPro2rel1spr2fea3().changeState(closedState);

		this.setPro2rel1spr2fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 2, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr2fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr2fea4().setManDayCosts(new Effort(4));
		this.getPro2rel1spr2fea4().setSprint(this.getPro2rel1spr2());
		this.getPro2rel1spr2fea4().changeState(closedState);

		this.setPro2rel1spr2fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 2, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr2fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr2fea5().setManDayCosts(new Effort(3));
		this.getPro2rel1spr2fea5().setSprint(this.getPro2rel1spr2());
		this.getPro2rel1spr2fea5().changeState(closedState);

		// für Projekt 2, Release 1, Sprint 3
		this.setPro2rel1spr3fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 3, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr3fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr3fea1().setManDayCosts(new Effort(3));
		this.getPro2rel1spr3fea1().setSprint(this.getPro2rel1spr3());
		// pro2rel1spr3fea1.changeState(closedState);

		this.setPro2rel1spr3fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 3, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr3fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr3fea2().setManDayCosts(new Effort(4));
		this.getPro2rel1spr3fea2().setSprint(this.getPro2rel1spr3());
		// pro2rel1spr3fea2.changeState(closedState);

		this.setPro2rel1spr3fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 3, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr3fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr3fea3().setManDayCosts(new Effort(5));
		this.getPro2rel1spr3fea3().setSprint(this.getPro2rel1spr3());
		// pro2rel1spr3fea3.changeState(closedState);

		this.setPro2rel1spr3fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 3, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr3fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr3fea4().setManDayCosts(new Effort(4));
		this.getPro2rel1spr3fea4().setSprint(this.getPro2rel1spr3());
		this.getPro2rel1spr3fea4().changeState(closedState);

		this.setPro2rel1spr3fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 3, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr3fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr3fea5().setManDayCosts(new Effort(3));
		this.getPro2rel1spr3fea5().setSprint(this.getPro2rel1spr3());
		this.getPro2rel1spr3fea5().changeState(closedState);

		// für Projekt 2, Release 1, Sprint 4
		this.setPro2rel1spr4fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 4, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr4fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr4fea1().setManDayCosts(new Effort(3));
		this.getPro2rel1spr4fea1().setSprint(this.getPro2rel1spr4());
		// pro2rel1spr4fea1.changeState(closedState);

		this.setPro2rel1spr4fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 4, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr4fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr4fea2().setManDayCosts(new Effort(4));
		this.getPro2rel1spr4fea2().setSprint(this.getPro2rel1spr4());
		// pro2rel1spr4fea2.changeState(closedState);

		this.setPro2rel1spr4fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 4, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr4fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr4fea3().setManDayCosts(new Effort(5));
		this.getPro2rel1spr4fea3().setSprint(this.getPro2rel1spr4());
		// pro2rel1spr4fea3.changeState(closedState);

		this.setPro2rel1spr4fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 4, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr4fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr4fea4().setManDayCosts(new Effort(4));
		this.getPro2rel1spr4fea4().setSprint(this.getPro2rel1spr4());
		// pro2rel1spr4fea4.changeState(closedState);

		this.setPro2rel1spr4fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 4, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr4fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr4fea5().setManDayCosts(new Effort(3));
		this.getPro2rel1spr4fea5().setSprint(this.getPro2rel1spr4());
		this.getPro2rel1spr4fea5().changeState(closedState);

		// für Projekt 2, Release 1, Sprint 5
		this.setPro2rel1spr5fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 5, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr5fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr5fea1().setManDayCosts(new Effort(3));
		this.getPro2rel1spr5fea1().setSprint(this.getPro2rel1spr5());
		// pro2rel1spr5fea1.changeState(closedState);

		this.setPro2rel1spr5fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 5, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr5fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr5fea2().setManDayCosts(new Effort(4));
		this.getPro2rel1spr5fea2().setSprint(this.getPro2rel1spr5());
		// pro2rel1spr5fea2.changeState(closedState);

		this.setPro2rel1spr5fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 5, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr5fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr5fea3().setManDayCosts(new Effort(5));
		this.getPro2rel1spr5fea3().setSprint(this.getPro2rel1spr5());
		// pro2rel1spr5fea3.changeState(closedState);

		this.setPro2rel1spr5fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 5, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr5fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr5fea4().setManDayCosts(new Effort(4));
		this.getPro2rel1spr5fea4().setSprint(this.getPro2rel1spr5());
		// pro2rel1spr5fea4.changeState(closedState);

		this.setPro2rel1spr5fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 1, Sprint 5, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel1spr5fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel1spr5fea5().setManDayCosts(new Effort(3));
		this.getPro2rel1spr5fea5().setSprint(this.getPro2rel1spr5());
		// pro2rel1spr5fea5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 1
		this.setPro2rel2spr1fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 1, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr1fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr1fea1().setManDayCosts(new Effort(20));
		this.getPro2rel2spr1fea1().setSprint(this.getPro2rel2spr1());
		this.getPro2rel2spr1fea1().changeState(closedState);

		this.setPro2rel2spr1fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 1, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr1fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr1fea2().setManDayCosts(new Effort(41));
		this.getPro2rel2spr1fea2().setSprint(this.getPro2rel2spr1());
		// pro2rel2spr1fea2.changeState(closedState);

		this.setPro2rel2spr1fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 1, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr1fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr1fea3().setManDayCosts(new Effort(57));
		this.getPro2rel2spr1fea3().setSprint(this.getPro2rel2spr1());
		// pro2rel2spr1fea3.changeState(closedState);

		this.setPro2rel2spr1fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 1, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr1fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr1fea4().setManDayCosts(new Effort(48));
		this.getPro2rel2spr1fea4().setSprint(this.getPro2rel2spr1());
		this.getPro2rel2spr1fea4().changeState(closedState);

		this.setPro2rel2spr1fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 1, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr1fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr1fea5().setManDayCosts(new Effort(3));
		this.getPro2rel2spr1fea5().setSprint(this.getPro2rel2spr1());
		this.getPro2rel2spr1fea5().changeState(closedState);

		// für Projekt 2, Release 2, Sprint 2
		this.setPro2rel2spr2fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 2, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr2fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr2fea1().setManDayCosts(new Effort(3));
		this.getPro2rel2spr2fea1().setSprint(this.getPro2rel2spr2());
		// pro2rel2spr2fea1.changeState(closedState);

		this.setPro2rel2spr2fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 2, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr2fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr2fea2().setManDayCosts(new Effort(18));
		this.getPro2rel2spr2fea2().setSprint(this.getPro2rel2spr2());
		this.getPro2rel2spr2fea2().changeState(closedState);

		this.setPro2rel2spr2fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 2, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr2fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr2fea3().setManDayCosts(new Effort(5));
		this.getPro2rel2spr2fea3().setSprint(this.getPro2rel2spr2());
		this.getPro2rel2spr2fea3().changeState(closedState);

		this.setPro2rel2spr2fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 2, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr2fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr2fea4().setManDayCosts(new Effort(13));
		this.getPro2rel2spr2fea4().setSprint(this.getPro2rel2spr2());
		// pro2rel2spr2fea4.changeState(closedState);

		this.setPro2rel2spr2fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 2, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr2fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr2fea5().setManDayCosts(new Effort(8));
		this.getPro2rel2spr2fea5().setSprint(this.getPro2rel2spr2());
		this.getPro2rel2spr2fea5().changeState(closedState);

		// für Projekt 2, Release 2, Sprint 3
		this.setPro2rel2spr3fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 3, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr3fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr3fea1().setManDayCosts(new Effort(18));
		this.getPro2rel2spr3fea1().setSprint(this.getPro2rel2spr3());
		this.getPro2rel2spr3fea1().changeState(closedState);

		this.setPro2rel2spr3fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 3, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr3fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr3fea2().setManDayCosts(new Effort(19));
		this.getPro2rel2spr3fea2().setSprint(this.getPro2rel2spr3());
		this.getPro2rel2spr3fea2().changeState(closedState);

		this.setPro2rel2spr3fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 3, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr3fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr3fea3().setManDayCosts(new Effort(15));
		this.getPro2rel2spr3fea3().setSprint(this.getPro2rel2spr3());
		// pro2rel2spr3fea3.changeState(closedState);

		this.setPro2rel2spr3fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 3, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr3fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr3fea4().setManDayCosts(new Effort(2));
		this.getPro2rel2spr3fea4().setSprint(this.getPro2rel2spr3());
		// pro2rel2spr3fea4.changeState(closedState);

		this.setPro2rel2spr3fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 3, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr3fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr3fea5().setManDayCosts(new Effort(6));
		this.getPro2rel2spr3fea5().setSprint(this.getPro2rel2spr3());
		this.getPro2rel2spr3fea5().changeState(closedState);

		// für Projekt 2, Release 2, Sprint 4
		this.setPro2rel2spr4fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 4, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr4fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr4fea1().setManDayCosts(new Effort(13));
		this.getPro2rel2spr4fea1().setSprint(this.getPro2rel2spr4());
		this.getPro2rel2spr4fea1().changeState(closedState);

		this.setPro2rel2spr4fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 4, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr4fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr4fea2().setManDayCosts(new Effort(15));
		this.getPro2rel2spr4fea2().setSprint(this.getPro2rel2spr4());
		// pro2rel2spr4fea2.changeState(closedState);

		this.setPro2rel2spr4fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 4, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr4fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr4fea3().setManDayCosts(new Effort(7));
		this.getPro2rel2spr4fea3().setSprint(this.getPro2rel2spr4());
		this.getPro2rel2spr4fea3().changeState(closedState);

		this.setPro2rel2spr4fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 4, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr4fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr4fea4().setManDayCosts(new Effort(4));
		this.getPro2rel2spr4fea4().setSprint(this.getPro2rel2spr4());
		this.getPro2rel2spr4fea4().changeState(closedState);

		this.setPro2rel2spr4fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 4, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr4fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr4fea5().setManDayCosts(new Effort(6));
		this.getPro2rel2spr4fea5().setSprint(this.getPro2rel2spr4());
		// pro2rel2spr4fea5.changeState(closedState);

		// für Projekt 2, Release 2, Sprint 5
		this.setPro2rel2spr5fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 5, Feature 1", "Beschreibung Feature 1", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr5fea1().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr5fea1().setManDayCosts(new Effort(7));
		this.getPro2rel2spr5fea1().setSprint(this.getPro2rel2spr5());
		this.getPro2rel2spr5fea1().changeState(closedState);

		this.setPro2rel2spr5fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 5, Feature 2", "Beschreibung Feature 2", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr5fea2().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr5fea2().setManDayCosts(new Effort(8));
		this.getPro2rel2spr5fea2().setSprint(this.getPro2rel2spr5());
		// pro2rel2spr5fea2.changeState(closedState);

		this.setPro2rel2spr5fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 5, Feature 3", "Beschreibung Feature 3", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr5fea3().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr5fea3().setManDayCosts(new Effort(5));
		this.getPro2rel2spr5fea3().setSprint(this.getPro2rel2spr5());
		// pro2rel2spr5fea3.changeState(closedState);

		this.setPro2rel2spr5fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 5, Feature 4", "Beschreibung Feature 4", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr5fea4().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr5fea4().setManDayCosts(new Effort(2));
		this.getPro2rel2spr5fea4().setSprint(this.getPro2rel2spr5());
		this.getPro2rel2spr5fea4().changeState(closedState);

		this.setPro2rel2spr5fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 2, Release 2, Sprint 5, Feature 5", "Beschreibung Feature 5", this.getProjekt2().getBacklog()));
		this.getPro2rel2spr5fea5().setLastEditor(this.getpBjoern());
		this.getPro2rel2spr5fea5().setManDayCosts(new Effort(3));
		this.getPro2rel2spr5fea5().setSprint(this.getPro2rel2spr5());
		this.getPro2rel2spr5fea5().changeState(closedState);

		// für Projekt 3, Release 1, Sprint 1
		this.setPro3rel1spr1fea1(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 1, Sprint 1, Feature 1",
				"Beschreibung Feature 1", this.getProjekt3().getBacklog(), this.getPro3rel1()));
		this.getPro3rel1spr1fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr1fea1().setManDayCosts(new Effort(3));
		this.getPro3rel1spr1fea1().setSprint(this.getPro3rel1spr1());
		this.getPro3rel1spr1fea1().changeState(closedState);

		this.setPro3rel1spr1fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 1, Feature 2", "Beschreibung Feature 2", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr1fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr1fea2().setManDayCosts(new Effort(4));
		this.getPro3rel1spr1fea2().setSprint(this.getPro3rel1spr1());
		this.getPro3rel1spr1fea2().changeState(closedState);

		this.setPro3rel1spr1fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 1, Feature 3", "Beschreibung Feature 3", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr1fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr1fea3().setManDayCosts(new Effort(5));
		this.getPro3rel1spr1fea3().setSprint(this.getPro3rel1spr1());
		// pro1rel1spr1fea3.changeState(closedState);

		this.setPro3rel1spr1fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 1, Feature 4", "Beschreibung Feature 4", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr1fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr1fea4().setManDayCosts(new Effort(4));
		this.getPro3rel1spr1fea4().setSprint(this.getPro3rel1spr1());
		// pro1rel1spr1fea4.changeState(closedState);

		this.setPro3rel1spr1fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 1, Feature 5", "Beschreibung Feature 5", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr1fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr1fea5().setManDayCosts(new Effort(3));
		this.getPro3rel1spr1fea5().setSprint(this.getPro3rel1spr1());
		this.getPro3rel1spr1fea5().changeState(closedState);

		// für Projekt 3, Release 1, Sprint 2
		this.setPro3rel1spr2fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 2, Feature 1", "Beschreibung Feature 1", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr2fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr2fea1().setManDayCosts(new Effort(2));
		this.getPro3rel1spr2fea1().setSprint(this.getPro3rel1spr2());
		this.getPro3rel1spr2fea1().changeState(closedState);

		this.setPro3rel1spr2fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 2, Feature 2", "Beschreibung Feature 2", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr2fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr2fea2().setManDayCosts(new Effort(10));
		this.getPro3rel1spr2fea2().setSprint(this.getPro3rel1spr2());
		// pro1rel1spr2fea2.changeState(closedState);

		this.setPro3rel1spr2fea3(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 1, Sprint 2, Feature 3",
				"Beschreibung Feature 3", this.getProjekt3().getBacklog(), this.getPro3rel1()));
		this.getPro3rel1spr2fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr2fea3().setManDayCosts(new Effort(15));
		this.getPro3rel1spr2fea3().setSprint(this.getPro3rel1spr2());
		this.getPro3rel1spr2fea3().changeState(closedState);

		this.setPro3rel1spr2fea4(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 1, Sprint 2, Feature 4",
				"Beschreibung Feature 4", this.getProjekt3().getBacklog(), this.getPro3rel1()));
		this.getPro3rel1spr2fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr2fea4().setManDayCosts(new Effort(3));
		this.getPro3rel1spr2fea4().setSprint(this.getPro3rel1spr2());
		this.getPro3rel1spr2fea4().changeState(closedState);

		this.setPro3rel1spr2fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 2, Feature 5", "Beschreibung Feature 5", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr2fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr2fea5().setManDayCosts(new Effort(6));
		this.getPro3rel1spr2fea5().setSprint(this.getPro3rel1spr2());
		// pro1rel1spr2fea5.changeState(closedState);

		// für Projekt 3, Release 1, Sprint 3
		this.setPro3rel1spr3fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 3, Feature 1", "Beschreibung Feature 1", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr3fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr3fea1().setManDayCosts(new Effort(20));
		this.getPro3rel1spr3fea1().setSprint(this.getPro3rel1spr3());
		// pro1rel1spr3fea1.changeState(closedState);

		this.setPro3rel1spr3fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 3, Feature 2", "Beschreibung Feature 2", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr3fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr3fea2().setManDayCosts(new Effort(6));
		this.getPro3rel1spr3fea2().setSprint(this.getPro3rel1spr3());
		// pro1rel1spr3fea2.changeState(closedState);

		this.setPro3rel1spr3fea3(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 1, Sprint 3, Feature 3",
				"Beschreibung Feature 3", this.getProjekt3().getBacklog(), this.getPro3rel1()));
		this.getPro3rel1spr3fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr3fea3().setManDayCosts(new Effort(48));
		this.getPro3rel1spr3fea3().setSprint(this.getPro3rel1spr3());
		this.getPro3rel1spr3fea3().changeState(closedState);

		this.setPro3rel1spr3fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 3, Feature 4", "Beschreibung Feature 4", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr3fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr3fea4().setManDayCosts(new Effort(2));
		this.getPro3rel1spr3fea4().setSprint(this.getPro3rel1spr3());
		this.getPro3rel1spr3fea4().changeState(closedState);

		this.setPro3rel1spr3fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 3, Feature 5", "Beschreibung Feature 5", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr3fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr3fea5().setManDayCosts(new Effort(1));
		this.getPro3rel1spr3fea5().setSprint(this.getPro3rel1spr3());
		// pro1rel1spr3fea5.changeState(closedState);

		// für Projekt 3, Release 1, Sprint 4
		this.setPro3rel1spr4fea1(new Bug(this.getModel(), bugTicketType, "Projekt 3 , Release 1, Sprint 4, Feature 1",
				"Beschreibung Feature 1", this.getProjekt3().getBacklog(), this.getPro3rel1()));
		this.getPro3rel1spr4fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr4fea1().setManDayCosts(new Effort(4));
		this.getPro3rel1spr4fea1().setSprint(this.getPro3rel1spr4());
		// pro1rel1spr4fea1.changeState(closedState);

		this.setPro3rel1spr4fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 4, Feature 2", "Beschreibung Feature 2", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr4fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr4fea2().setManDayCosts(new Effort(10));
		this.getPro3rel1spr4fea2().setSprint(this.getPro3rel1spr4());
		// pro1rel1spr4fea2.changeState(closedState);

		this.setPro3rel1spr4fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 4, Feature 3", "Beschreibung Feature 3", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr4fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr4fea3().setManDayCosts(new Effort(5));
		this.getPro3rel1spr4fea3().setSprint(this.getPro3rel1spr4());
		// pro1rel1spr4fea3.changeState(closedState);

		this.setPro3rel1spr4fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 4, Feature 4", "Beschreibung Feature 4", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr4fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr4fea4().setManDayCosts(new Effort(9));
		this.getPro3rel1spr4fea4().setSprint(this.getPro3rel1spr4());
		// pro1rel1spr4fea4.changeState(closedState);

		this.setPro3rel1spr4fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 4, Feature 5", "Beschreibung Feature 5", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr4fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr4fea5().setManDayCosts(new Effort(3));
		this.getPro3rel1spr4fea5().setSprint(this.getPro3rel1spr4());
		// pro1rel1spr4fea5.changeState(closedState);

		// für Projekt 3, Release 1, Sprint 5
		this.setPro3rel1spr5fea1(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 1, Sprint 5, Feature 1",
				"Beschreibung Feature 1", this.getProjekt3().getBacklog(), this.getPro3rel1()));
		this.getPro3rel1spr5fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr5fea1().setManDayCosts(new Effort(16));
		this.getPro3rel1spr5fea1().setSprint(this.getPro3rel1spr5());
		this.getPro3rel1spr5fea1().changeState(closedState);

		this.setPro3rel1spr5fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 5, Feature 2", "Beschreibung Feature 2", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr5fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr5fea2().setManDayCosts(new Effort(4));
		this.getPro3rel1spr5fea2().setSprint(this.getPro3rel1spr5());
		this.getPro3rel1spr5fea2().changeState(closedState);

		this.setPro3rel1spr5fea3(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 1, Sprint 5, Feature 3",
				"Beschreibung Feature 3", this.getProjekt3().getBacklog(), this.getPro3rel1()));
		this.getPro3rel1spr5fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr5fea3().setManDayCosts(new Effort(5));
		this.getPro3rel1spr5fea3().setSprint(this.getPro3rel1spr5());
		this.getPro3rel1spr5fea3().changeState(closedState);

		this.setPro3rel1spr5fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 1, Sprint 5, Feature 4", "Beschreibung Feature 4", this.getProjekt3().getBacklog()));
		this.getPro3rel1spr5fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr5fea4().setManDayCosts(new Effort(35));
		this.getPro3rel1spr5fea4().setSprint(this.getPro3rel1spr5());
		this.getPro3rel1spr5fea4().changeState(closedState);

		this.setPro3rel1spr5fea5(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 1, Sprint 5, Feature 5",
				"Beschreibung Feature 5", this.getProjekt3().getBacklog(), this.getPro3rel1()));
		this.getPro3rel1spr5fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel1spr5fea5().setManDayCosts(new Effort(3));
		this.getPro3rel1spr5fea5().setSprint(this.getPro3rel1spr5());
		this.getPro3rel1spr5fea5().changeState(closedState);

		// für Projekt 3, Release 2, Sprint 1
		this.setPro3rel2spr1fea1(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 1, Feature 1",
				"Beschreibung Feature 1", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr1fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr1fea1().setManDayCosts(new Effort(80));
		this.getPro3rel2spr1fea1().setSprint(this.getPro3rel2spr1());
		this.getPro3rel2spr1fea1().changeState(closedState);

		this.setPro3rel2spr1fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 1, Feature 2", "Beschreibung Feature 2", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr1fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr1fea2().setManDayCosts(new Effort(20));
		this.getPro3rel2spr1fea2().setSprint(this.getPro3rel2spr1());
		// pro1rel2spr1fea2.changeState(closedState);

		this.setPro3rel2spr1fea3(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 1, Feature 3",
				"Beschreibung Feature 3", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr1fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr1fea3().setManDayCosts(new Effort(5));
		this.getPro3rel2spr1fea3().setSprint(this.getPro3rel2spr1());
		this.getPro3rel2spr1fea3().changeState(closedState);

		this.setPro3rel2spr1fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 1, Feature 4", "Beschreibung Feature 4", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr1fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr1fea4().setManDayCosts(new Effort(4));
		this.getPro3rel2spr1fea4().setSprint(this.getPro3rel2spr1());
		this.getPro3rel2spr1fea4().changeState(closedState);

		this.setPro3rel2spr1fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 1, Feature 5", "Beschreibung Feature 5", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr1fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr1fea5().setManDayCosts(new Effort(3));
		this.getPro3rel2spr1fea5().setSprint(this.getPro3rel2spr1());
		this.getPro3rel2spr1fea5().changeState(closedState);

		// für Projekt 3, Release 2, Sprint 2
		this.setPro3rel2spr2fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 2, Feature 1", "Beschreibung Feature 1", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr2fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr2fea1().setManDayCosts(new Effort(5));
		this.getPro3rel2spr2fea1().setSprint(this.getPro3rel2spr2());
		// pro1rel2spr2fea1.changeState(closedState);

		this.setPro3rel2spr2fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 2, Feature 2", "Beschreibung Feature 2", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr2fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr2fea2().setManDayCosts(new Effort(20));
		this.getPro3rel2spr2fea2().setSprint(this.getPro3rel2spr2());
		// pro1rel2spr2fea2.changeState(closedState);

		this.setPro3rel2spr2fea3(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 2, Feature 3",
				"Beschreibung Feature 3", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr2fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr2fea3().setManDayCosts(new Effort(5));
		this.getPro3rel2spr2fea3().setSprint(this.getPro3rel2spr2());
		// pro1rel2spr2fea3.changeState(closedState);

		this.setPro3rel2spr2fea4(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 2, Feature 4",
				"Beschreibung Feature 4", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr2fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr2fea4().setManDayCosts(new Effort(6));
		this.getPro3rel2spr2fea4().setSprint(this.getPro3rel2spr2());
		this.getPro3rel2spr2fea4().changeState(closedState);

		this.setPro3rel2spr2fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 2, Feature 5", "Beschreibung Feature 5", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr2fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr2fea5().setManDayCosts(new Effort(35));
		this.getPro3rel2spr2fea5().setSprint(this.getPro3rel2spr2());
		this.getPro3rel2spr2fea5().changeState(closedState);

		// für Projekt 3, Release 2, Sprint 3
		this.setPro3rel2spr3fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 3, Feature 1", "Beschreibung Feature 1", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr3fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr3fea1().setManDayCosts(new Effort(13));
		this.getPro3rel2spr3fea1().setSprint(this.getPro3rel2spr3());
		this.getPro3rel2spr3fea1().changeState(closedState);

		this.setPro3rel2spr3fea2(new Bug(this.getModel(), bugTicketType, "Projekt 1, Release 2, Sprint 3, Feature 2",
				"Beschreibung Feature 2", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr3fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr3fea2().setManDayCosts(new Effort(7));
		this.getPro3rel2spr3fea2().setSprint(this.getPro3rel2spr3());
		this.getPro3rel2spr3fea2().changeState(closedState);

		this.setPro3rel2spr3fea3(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 3, Feature 3", "Beschreibung Feature 3", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr3fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr3fea3().setManDayCosts(new Effort(100));
		this.getPro3rel2spr3fea3().setSprint(this.getPro3rel2spr3());
		// pro1rel2spr3fea3.changeState(closedState);

		this.setPro3rel2spr3fea4(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 3, Feature 4", "Beschreibung Feature 4", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr3fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr3fea4().setManDayCosts(new Effort(83));
		this.getPro3rel2spr3fea4().setSprint(this.getPro3rel2spr3());
		this.getPro3rel2spr3fea4().changeState(closedState);

		this.setPro3rel2spr3fea5(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 3, Feature 5",
				"Beschreibung Feature 5", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr3fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr3fea5().setManDayCosts(new Effort(3));
		this.getPro3rel2spr3fea5().setSprint(this.getPro3rel2spr3());
		// pro1rel2spr3fea5.changeState(closedState);

		// für Projekt 3, Release 2, Sprint 4
		this.setPro3rel2spr4fea1(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 4, Feature 1", "Beschreibung Feature 1", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr4fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr4fea1().setManDayCosts(new Effort(20));
		this.getPro3rel2spr4fea1().setSprint(this.getPro3rel2spr4());
		this.getPro3rel2spr4fea1().changeState(closedState);

		this.setPro3rel2spr4fea2(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 4, Feature 2", "Beschreibung Feature 2", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr4fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr4fea2().setManDayCosts(new Effort(14));
		this.getPro3rel2spr4fea2().setSprint(this.getPro3rel2spr4());
		// pro1rel2spr4fea2.changeState(closedState);

		this.setPro3rel2spr4fea3(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 4, Feature 3",
				"Beschreibung Feature 3", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr4fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr4fea3().setManDayCosts(new Effort(80));
		this.getPro3rel2spr4fea3().setSprint(this.getPro3rel2spr4());
		this.getPro3rel2spr4fea3().changeState(closedState);

		this.setPro3rel2spr4fea4(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 4, Feature 4",
				"Beschreibung Feature 4", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr4fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr4fea4().setManDayCosts(new Effort(12));
		this.getPro3rel2spr4fea4().setSprint(this.getPro3rel2spr4());
		// pro1rel2spr4fea4.changeState(closedState);

		this.setPro3rel2spr4fea5(new Feature(this.getModel(), featureTicketType,
				"Projekt 3, Release 2, Sprint 4, Feature 5", "Beschreibung Feature 5", this.getProjekt3().getBacklog()));
		this.getPro3rel2spr4fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr4fea5().setManDayCosts(new Effort(16));
		this.getPro3rel2spr4fea5().setSprint(this.getPro3rel2spr4());
		this.getPro3rel2spr4fea5().changeState(closedState);

		// für Projekt 3, Release 2, Sprint 5
		this.setPro3rel2spr5fea1(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 5, Feature 1",
				"Beschreibung Feature 1", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr5fea1().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr5fea1().setManDayCosts(new Effort(13));
		this.getPro3rel2spr5fea1().setSprint(this.getPro3rel2spr5());
		// pro1rel2spr5fea1.changeState(closedState);

		this.setPro3rel2spr5fea2(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 5, Feature 2",
				"Beschreibung Feature 2", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr5fea2().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr5fea2().setManDayCosts(new Effort(14));
		this.getPro3rel2spr5fea2().setSprint(this.getPro3rel2spr5());
		this.getPro3rel2spr5fea2().changeState(closedState);

		this.setPro3rel2spr5fea3(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 5, Feature 3",
				"Beschreibung Feature 3", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr5fea3().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr5fea3().setManDayCosts(new Effort(5));
		this.getPro3rel2spr5fea3().setSprint(this.getPro3rel2spr5());
		this.getPro3rel2spr5fea3().changeState(closedState);

		this.setPro3rel2spr5fea4(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 5, Feature 4",
				"Beschreibung Feature 4", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr5fea4().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr5fea4().setManDayCosts(new Effort(4));
		this.getPro3rel2spr5fea4().setSprint(this.getPro3rel2spr5());
		// pro1rel2spr5fea4.changeState(closedState);

		this.setPro3rel2spr5fea5(new Bug(this.getModel(), bugTicketType, "Projekt 3, Release 2, Sprint 5, Feature 5",
				"Beschreibung Feature 5", this.getProjekt3().getBacklog(), this.getPro3rel2()));
		this.getPro3rel2spr5fea5().setLastEditor(this.getpBjoern());
		this.getPro3rel2spr5fea5().setManDayCosts(new Effort(3));
		this.getPro3rel2spr5fea5().setSprint(this.getPro3rel2spr5());
		this.getPro3rel2spr5fea5().changeState(closedState);

		// Initial Tasks
		// für Projekt 1, Release 1, Sprint 1
		final TaskTicketType taskTicketType = this.getModel().getTypeManager().getStandardTaskType();
		this.setPro1rel1spr1tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 1, Task 1",
				"Beschreibung von Task 1", this.getPro1rel1spr1().getSprintBacklog()));
		this.getPro1rel1spr1().getSprintBacklog().addTask(this.getPro1rel1spr1tas1());
		this.getPro1rel1spr1tas1().addPBI(this.getPro1rel1spr1fea1());
		this.getPro1rel1spr1tas1().setPlanEffort(new Effort(1));
		this.getPro1rel1spr1tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr1tas1().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr1tas1().setFinishDate(new Date(2011 - 1900, 2 - 1, 3));
		this.getPro1rel1spr1tas1().changeState(closedState);

		this.setPro1rel1spr1tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 1, Task 2",
				"Beschreibung von Task 2", this.getPro1rel1spr1().getSprintBacklog()));
		this.getPro1rel1spr1().getSprintBacklog().addTask(this.getPro1rel1spr1tas2());
		this.getPro1rel1spr1tas2().addPBI(this.getPro1rel1spr1fea2());
		this.getPro1rel1spr1tas2().setPlanEffort(new Effort(2));
		this.getPro1rel1spr1tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr1tas2().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr1tas2().setFinishDate(new Date(2011 - 1900, 2 - 1, 3));
		this.getPro1rel1spr1tas2().changeState(closedState);

		this.setPro1rel1spr1tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 1, Task 3",
				"Beschreibung von Task 3", this.getPro1rel1spr1().getSprintBacklog()));
		this.getPro1rel1spr1().getSprintBacklog().addTask(this.getPro1rel1spr1tas3());
		this.getPro1rel1spr1tas3().addPBI(this.getPro1rel1spr1fea3());
		this.getPro1rel1spr1tas3().setPlanEffort(new Effort(3));
		this.getPro1rel1spr1tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr1tas3().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr1tas3().setFinishDate(new Date(2011 - 1900, 2 - 1, 1, 12, 0));
		this.getPro1rel1spr1tas3().changeState(closedState);

		this.setPro1rel1spr1tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 1, Task 4",
				"Beschreibung von Task 4", this.getPro1rel1spr1().getSprintBacklog()));
		this.getPro1rel1spr1().getSprintBacklog().addTask(this.getPro1rel1spr1tas4());
		this.getPro1rel1spr1tas4().addPBI(this.getPro1rel1spr1fea4());
		this.getPro1rel1spr1tas4().setPlanEffort(new Effort(4));
		this.getPro1rel1spr1tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr1tas4().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr1tas4().setFinishDate(new Date(2011 - 1900, 2 - 1, 2, 12, 0));
		this.getPro1rel1spr1tas4().changeState(closedState);

		this.setPro1rel1spr1tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 1, Task 5",
				"Beschreibung von Task 5", this.getPro1rel1spr1().getSprintBacklog()));
		this.getPro1rel1spr1().getSprintBacklog().addTask(this.getPro1rel1spr1tas5());
		this.getPro1rel1spr1tas5().addPBI(this.getPro1rel1spr1fea5());
		this.getPro1rel1spr1tas5().setPlanEffort(new Effort(5));
		this.getPro1rel1spr1tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr1tas5().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr1tas5().setFinishDate(new Date(2011 - 1900, 2 - 1, 4, 12, 0));
		this.getPro1rel1spr1tas5().changeState(closedState);

		// für Projekt 1, Release 1, Sprint 2
		this.setPro1rel1spr2tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 2, Task 1",
				"Beschreibung von Task 1", this.getPro1rel1spr2().getSprintBacklog()));
		this.getPro1rel1spr2().getSprintBacklog().addTask(this.getPro1rel1spr2tas1());
		this.getPro1rel1spr2tas1().addPBI(this.getPro1rel1spr2fea1());
		this.getPro1rel1spr2tas1().setPlanEffort(new Effort(6));
		this.getPro1rel1spr2tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr2tas1().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr2tas1().setFinishDate(new Date(2011 - 1900, 3 - 1, 13, 12, 0));
		this.getPro1rel1spr2tas1().changeState(closedState);

		this.setPro1rel1spr2tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 2, Task 2",
				"Beschreibung von Task 2", this.getPro1rel1spr2().getSprintBacklog()));
		this.getPro1rel1spr2().getSprintBacklog().addTask(this.getPro1rel1spr2tas2());
		this.getPro1rel1spr2tas2().addPBI(this.getPro1rel1spr2fea2());
		this.getPro1rel1spr2tas2().setPlanEffort(new Effort(7));
		this.getPro1rel1spr2tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr2tas2().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr2tas2().setFinishDate(new Date(2011 - 1900, 3 - 1, 14, 12, 0));
		this.getPro1rel1spr2tas2().changeState(closedState);

		this.setPro1rel1spr2tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 2, Task 3",
				"Beschreibung von Task 3", this.getPro1rel1spr2().getSprintBacklog()));
		this.getPro1rel1spr2().getSprintBacklog().addTask(this.getPro1rel1spr2tas3());
		this.getPro1rel1spr2tas3().addPBI(this.getPro1rel1spr2fea3());
		this.getPro1rel1spr2tas3().setPlanEffort(new Effort(8));
		this.getPro1rel1spr2tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr2tas3().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr2tas3().setFinishDate(new Date(2011 - 1900, 3 - 1, 14, 12, 0));
		this.getPro1rel1spr2tas3().changeState(closedState);

		this.setPro1rel1spr2tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 2, Task 4",
				"Beschreibung von Task 4", this.getPro1rel1spr2().getSprintBacklog()));
		this.getPro1rel1spr2().getSprintBacklog().addTask(this.getPro1rel1spr2tas4());
		this.getPro1rel1spr2tas4().addPBI(this.getPro1rel1spr2fea4());
		this.getPro1rel1spr2tas4().setPlanEffort(new Effort(1));
		this.getPro1rel1spr2tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr2tas4().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr2tas4().setFinishDate(new Date(2011 - 1900, 3 - 1, 13, 12, 0));
		this.getPro1rel1spr2tas4().changeState(closedState);

		this.setPro1rel1spr2tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 2, Task 5",
				"Beschreibung von Task 5", this.getPro1rel1spr2().getSprintBacklog()));
		this.getPro1rel1spr2().getSprintBacklog().addTask(this.getPro1rel1spr2tas5());
		this.getPro1rel1spr2tas5().addPBI(this.getPro1rel1spr2fea5());
		this.getPro1rel1spr2tas5().setPlanEffort(new Effort(2));
		this.getPro1rel1spr2tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr2tas5().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr2tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 12, 12, 0));
		this.getPro1rel1spr2tas5().changeState(closedState);

		// für Projekt 1, Release 1, Sprint 3
		this.setPro1rel1spr3tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 3, Task 1",
				"Beschreibung von Task 1", this.getPro1rel1spr3().getSprintBacklog()));
		this.getPro1rel1spr3().getSprintBacklog().addTask(this.getPro1rel1spr3tas1());
		this.getPro1rel1spr3tas1().addPBI(this.getPro1rel1spr3fea1());
		this.getPro1rel1spr3tas1().setPlanEffort(new Effort(7));
		this.getPro1rel1spr3tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr3tas1().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr3tas1().setFinishDate(new Date(2011 - 1900, 1 - 1, 4, 12, 0));
		this.getPro1rel1spr3tas1().changeState(closedState);

		this.setPro1rel1spr3tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 3, Task 2",
				"Beschreibung von Task 2", this.getPro1rel1spr3().getSprintBacklog()));
		this.getPro1rel1spr3().getSprintBacklog().addTask(this.getPro1rel1spr3tas2());
		this.getPro1rel1spr3tas2().addPBI(this.getPro1rel1spr3fea2());
		this.getPro1rel1spr3tas2().setPlanEffort(new Effort(7));
		this.getPro1rel1spr3tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr3tas2().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr3tas2().setFinishDate(new Date(2011 - 1900, 1 - 1, 4, 12, 0));
		this.getPro1rel1spr3tas2().changeState(closedState);

		this.setPro1rel1spr3tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 3, Task 3",
				"Beschreibung von Task 3", this.getPro1rel1spr3().getSprintBacklog()));
		this.getPro1rel1spr3().getSprintBacklog().addTask(this.getPro1rel1spr3tas3());
		this.getPro1rel1spr3tas3().addPBI(this.getPro1rel1spr3fea3());
		this.getPro1rel1spr3tas3().setPlanEffort(new Effort(7));
		this.getPro1rel1spr3tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr3tas3().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr3tas3().setFinishDate(new Date(2011 - 1900, 1 - 1, 3, 12, 0));
		this.getPro1rel1spr3tas3().changeState(closedState);

		this.setPro1rel1spr3tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 3, Task 4",
				"Beschreibung von Task 4", this.getPro1rel1spr3().getSprintBacklog()));
		this.getPro1rel1spr3().getSprintBacklog().addTask(this.getPro1rel1spr3tas4());
		this.getPro1rel1spr3tas4().addPBI(this.getPro1rel1spr3fea4());
		this.getPro1rel1spr3tas4().setPlanEffort(new Effort(7));
		this.getPro1rel1spr3tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr3tas4().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr3tas4().setFinishDate(new Date(2011 - 1900, 1 - 1, 3, 12, 0));
		this.getPro1rel1spr3tas4().changeState(closedState);

		this.setPro1rel1spr3tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 3, Task 5",
				"Beschreibung von Task 5", this.getPro1rel1spr3().getSprintBacklog()));
		this.getPro1rel1spr3().getSprintBacklog().addTask(this.getPro1rel1spr3tas5());
		this.getPro1rel1spr3tas5().addPBI(this.getPro1rel1spr3fea5());
		this.getPro1rel1spr3tas5().setPlanEffort(new Effort(7));
		this.getPro1rel1spr3tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr3tas5().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr3tas5().setFinishDate(new Date(2011 - 1900, 1 - 1, 4, 12, 0));
		this.getPro1rel1spr3tas5().changeState(closedState);

		// für Projekt 1, Release 1, Sprint 4
		this.setPro1rel1spr4tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 4, Task 1",
				"Beschreibung von Task 1", this.getPro1rel1spr4().getSprintBacklog()));
		this.getPro1rel1spr4().getSprintBacklog().addTask(this.getPro1rel1spr4tas1());
		this.getPro1rel1spr4tas1().addPBI(this.getPro1rel1spr4fea1());
		this.getPro1rel1spr4tas1().setPlanEffort(new Effort(2));
		this.getPro1rel1spr4tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr4tas1().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr4tas1().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro1rel1spr4tas1().changeState(closedState);

		this.setPro1rel1spr4tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 4, Task 2",
				"Beschreibung von Task 2", this.getPro1rel1spr4().getSprintBacklog()));
		this.getPro1rel1spr4().getSprintBacklog().addTask(this.getPro1rel1spr4tas2());
		this.getPro1rel1spr4tas2().addPBI(this.getPro1rel1spr4fea2());
		this.getPro1rel1spr4tas2().setPlanEffort(new Effort(2));
		this.getPro1rel1spr4tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr4tas2().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr4tas2().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro1rel1spr4tas2().changeState(closedState);

		this.setPro1rel1spr4tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 4, Task 3",
				"Beschreibung von Task 3", this.getPro1rel1spr4().getSprintBacklog()));
		this.getPro1rel1spr4().getSprintBacklog().addTask(this.getPro1rel1spr4tas3());
		this.getPro1rel1spr4tas3().addPBI(this.getPro1rel1spr4fea3());
		this.getPro1rel1spr4tas3().setPlanEffort(new Effort(2));
		this.getPro1rel1spr4tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr4tas3().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr4tas3().setFinishDate(new Date(2011 - 1900, 2 - 1, 28, 12, 0));
		this.getPro1rel1spr4tas3().changeState(closedState);

		this.setPro1rel1spr4tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 4, Task 4",
				"Beschreibung von Task 4", this.getPro1rel1spr4().getSprintBacklog()));
		this.getPro1rel1spr4().getSprintBacklog().addTask(this.getPro1rel1spr4tas4());
		this.getPro1rel1spr4tas4().addPBI(this.getPro1rel1spr4fea4());
		this.getPro1rel1spr4tas4().setPlanEffort(new Effort(3));
		this.getPro1rel1spr4tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr4tas4().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr4tas4().setFinishDate(new Date(2011 - 1900, 2 - 1, 28, 12, 0));
		this.getPro1rel1spr4tas4().changeState(closedState);

		this.setPro1rel1spr4tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 4, Task 5",
				"Beschreibung von Task 5", this.getPro1rel1spr4().getSprintBacklog()));
		this.getPro1rel1spr4().getSprintBacklog().addTask(this.getPro1rel1spr4tas5());
		this.getPro1rel1spr4tas5().addPBI(this.getPro1rel1spr4fea5());
		this.getPro1rel1spr4tas5().setPlanEffort(new Effort(8));
		this.getPro1rel1spr4tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr4tas5().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr4tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.getPro1rel1spr4tas5().changeState(closedState);

		// für Projekt 1, Release 1, Sprint 5
		this.setPro1rel1spr5tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 5, Task 1",
				"Beschreibung von Task 1", this.getPro1rel1spr5().getSprintBacklog()));
		this.getPro1rel1spr5().getSprintBacklog().addTask(this.getPro1rel1spr5tas1());
		this.getPro1rel1spr5tas1().addPBI(this.getPro1rel1spr5fea1());
		this.getPro1rel1spr5tas1().setPlanEffort(new Effort(5));
		this.getPro1rel1spr5tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr5tas1().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr5tas1().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro1rel1spr5tas1().changeState(closedState);

		this.setPro1rel1spr5tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 5, Task 2",
				"Beschreibung von Task 2", this.getPro1rel1spr5().getSprintBacklog()));
		this.getPro1rel1spr5().getSprintBacklog().addTask(this.getPro1rel1spr5tas2());
		this.getPro1rel1spr5tas2().addPBI(this.getPro1rel1spr5fea2());
		this.getPro1rel1spr5tas2().setPlanEffort(new Effort(3));
		this.getPro1rel1spr5tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr5tas2().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr5tas2().setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.getPro1rel1spr5tas2().changeState(closedState);

		this.setPro1rel1spr5tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 5, Task 3",
				"Beschreibung von Task 3", this.getPro1rel1spr5().getSprintBacklog()));
		this.getPro1rel1spr5().getSprintBacklog().addTask(this.getPro1rel1spr5tas3());
		this.getPro1rel1spr5tas3().addPBI(this.getPro1rel1spr5fea3());
		this.getPro1rel1spr5tas3().setPlanEffort(new Effort(4));
		this.getPro1rel1spr5tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr5tas3().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr5tas3().setFinishDate(new Date(2011 - 1900, 3 - 1, 3, 12, 0));
		this.getPro1rel1spr5tas3().changeState(closedState);

		this.setPro1rel1spr5tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 5, Task 4",
				"Beschreibung von Task 4", this.getPro1rel1spr5().getSprintBacklog()));
		this.getPro1rel1spr5().getSprintBacklog().addTask(this.getPro1rel1spr5tas4());
		this.getPro1rel1spr5tas4().addPBI(this.getPro1rel1spr5fea4());
		this.getPro1rel1spr5tas4().setPlanEffort(new Effort(7));
		this.getPro1rel1spr5tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr5tas4().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr5tas4().setFinishDate(new Date(2011 - 1900, 3 - 1, 4, 12, 0));
		this.getPro1rel1spr5tas4().changeState(closedState);

		this.setPro1rel1spr5tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 1, Sprint 5, Task 5",
				"Beschreibung von Task 5", this.getPro1rel1spr5().getSprintBacklog()));
		this.getPro1rel1spr5().getSprintBacklog().addTask(this.getPro1rel1spr5tas5());
		this.getPro1rel1spr5tas5().addPBI(this.getPro1rel1spr5fea5());
		this.getPro1rel1spr5tas5().setPlanEffort(new Effort(2));
		this.getPro1rel1spr5tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel1spr5tas5().setResponsibility(this.getpBjoern());
		this.getPro1rel1spr5tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 10, 12, 0));
		this.getPro1rel1spr5tas5().changeState(closedState);

		// für Projekt 1, Release 2, Sprint 1
		this.setPro1rel2spr1tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 1, Task 1",
				"Beschreibung von Task 1", this.getPro1rel2spr1().getSprintBacklog()));
		this.getPro1rel2spr1().getSprintBacklog().addTask(this.getPro1rel2spr1tas1());
		this.getPro1rel2spr1tas1().addPBI(this.getPro1rel2spr1fea1());
		this.getPro1rel2spr1tas1().setPlanEffort(new Effort(8));
		this.getPro1rel2spr1tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr1tas1().setResponsibility(this.getpBjoern());
		// pro1rel2spr1tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr1tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 1, Task 2",
				"Beschreibung von Task 2", this.getPro1rel2spr1().getSprintBacklog()));
		this.getPro1rel2spr1().getSprintBacklog().addTask(this.getPro1rel2spr1tas2());
		this.getPro1rel2spr1tas2().addPBI(this.getPro1rel2spr1fea2());
		this.getPro1rel2spr1tas2().setPlanEffort(new Effort(6));
		this.getPro1rel2spr1tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr1tas2().setResponsibility(this.getpBjoern());
		// pro1rel2spr1tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr1tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 1, Task 3",
				"Beschreibung von Task 3", this.getPro1rel2spr1().getSprintBacklog()));
		this.getPro1rel2spr1().getSprintBacklog().addTask(this.getPro1rel2spr1tas3());
		this.getPro1rel2spr1tas3().addPBI(this.getPro1rel2spr1fea3());
		this.getPro1rel2spr1tas3().setPlanEffort(new Effort(4));
		this.getPro1rel2spr1tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr1tas3().setResponsibility(this.getpBjoern());
		// pro1rel2spr1tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr1tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 1, Task 4",
				"Beschreibung von Task 4", this.getPro1rel2spr1().getSprintBacklog()));
		this.getPro1rel2spr1().getSprintBacklog().addTask(this.getPro1rel2spr1tas4());
		this.getPro1rel2spr1tas4().addPBI(this.getPro1rel2spr1fea4());
		this.getPro1rel2spr1tas4().setPlanEffort(new Effort(6));
		this.getPro1rel2spr1tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr1tas4().setResponsibility(this.getpBjoern());
		// pro1rel2spr1tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr1tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 1, Task 5",
				"Beschreibung von Task 5", this.getPro1rel2spr1().getSprintBacklog()));
		this.getPro1rel2spr1().getSprintBacklog().addTask(this.getPro1rel2spr1tas5());
		this.getPro1rel2spr1tas5().addPBI(this.getPro1rel2spr1fea5());
		this.getPro1rel2spr1tas5().setPlanEffort(new Effort(8));
		this.getPro1rel2spr1tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr1tas5().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr1tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro1rel2spr1tas5().changeState(closedState);

		// für Projekt 1, Release 2, Sprint 2
		this.setPro1rel2spr2tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 2, Task 1",
				"Beschreibung von Task 1", this.getPro1rel2spr2().getSprintBacklog()));
		this.getPro1rel2spr2().getSprintBacklog().addTask(this.getPro1rel2spr2tas1());
		this.getPro1rel2spr2tas1().addPBI(this.getPro1rel2spr2fea1());
		this.getPro1rel2spr2tas1().setPlanEffort(new Effort(7));
		this.getPro1rel2spr2tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr2tas1().setResponsibility(this.getpBjoern());
		// pro1rel2spr2tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr2tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 2, Task 2",
				"Beschreibung von Task 2", this.getPro1rel2spr2().getSprintBacklog()));
		this.getPro1rel2spr2().getSprintBacklog().addTask(this.getPro1rel2spr2tas2());
		this.getPro1rel2spr2tas2().addPBI(this.getPro1rel2spr2fea2());
		this.getPro1rel2spr2tas2().setPlanEffort(new Effort(8));
		this.getPro1rel2spr2tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr2tas2().setResponsibility(this.getpBjoern());
		// pro1rel2spr2tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr2tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 2, Task 3",
				"Beschreibung von Task 3", this.getPro1rel2spr2().getSprintBacklog()));
		this.getPro1rel2spr2().getSprintBacklog().addTask(this.getPro1rel2spr2tas3());
		this.getPro1rel2spr2tas3().addPBI(this.getPro1rel2spr2fea3());
		this.getPro1rel2spr2tas3().setPlanEffort(new Effort(2));
		this.getPro1rel2spr2tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr2tas3().setResponsibility(this.getpBjoern());
		// pro1rel2spr2tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr2tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 2, Task 4",
				"Beschreibung von Task 4", this.getPro1rel2spr2().getSprintBacklog()));
		this.getPro1rel2spr2().getSprintBacklog().addTask(this.getPro1rel2spr2tas4());
		this.getPro1rel2spr2tas4().addPBI(this.getPro1rel2spr2fea4());
		this.getPro1rel2spr2tas4().setPlanEffort(new Effort(3));
		this.getPro1rel2spr2tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr2tas4().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr2tas4().setFinishDate(new Date(2011 - 1900, 3 - 1, 5, 12, 0));
		this.getPro1rel2spr2tas4().changeState(closedState);

		this.setPro1rel2spr2tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 2, Task 5",
				"Beschreibung von Task 5", this.getPro1rel2spr2().getSprintBacklog()));
		this.getPro1rel2spr2().getSprintBacklog().addTask(this.getPro1rel2spr2tas5());
		this.getPro1rel2spr2tas5().addPBI(this.getPro1rel2spr2fea5());
		this.getPro1rel2spr2tas5().setPlanEffort(new Effort(3));
		this.getPro1rel2spr2tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr2tas5().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr2tas5().setFinishDate(new Date(2011 - 1900, 2 - 1, 1, 12, 0));
		this.getPro1rel2spr2tas5().changeState(closedState);

		// für Projekt 1, Release 2, Sprint 3
		this.setPro1rel2spr3tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 3, Task 1",
				"Beschreibung von Task 1", this.getPro1rel2spr3().getSprintBacklog()));
		this.getPro1rel2spr3().getSprintBacklog().addTask(this.getPro1rel2spr3tas1());
		this.getPro1rel2spr3tas1().addPBI(this.getPro1rel2spr3fea1());
		this.getPro1rel2spr3tas1().setPlanEffort(new Effort(5));
		this.getPro1rel2spr3tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr3tas1().setResponsibility(this.getpBjoern());
		// pro1rel2spr3tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr3tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 3, Task 2",
				"Beschreibung von Task 2", this.getPro1rel2spr3().getSprintBacklog()));
		this.getPro1rel2spr3().getSprintBacklog().addTask(this.getPro1rel2spr3tas2());
		this.getPro1rel2spr3tas2().addPBI(this.getPro1rel2spr3fea2());
		this.getPro1rel2spr3tas2().setPlanEffort(new Effort(5));
		this.getPro1rel2spr3tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr3tas2().setResponsibility(this.getpBjoern());
		// pro1rel2spr3tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr3tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 3, Task 3",
				"Beschreibung von Task 3", this.getPro1rel2spr3().getSprintBacklog()));
		this.getPro1rel2spr3().getSprintBacklog().addTask(this.getPro1rel2spr3tas3());
		this.getPro1rel2spr3tas3().addPBI(this.getPro1rel2spr3fea3());
		this.getPro1rel2spr3tas3().setPlanEffort(new Effort(8));
		this.getPro1rel2spr3tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr3tas3().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr3tas3().setFinishDate(new Date(2011 - 1900, 3 - 1, 19, 12, 0));
		this.getPro1rel2spr3tas3().changeState(closedState);

		this.setPro1rel2spr3tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 3, Task 4",
				"Beschreibung von Task 4", this.getPro1rel2spr3().getSprintBacklog()));
		this.getPro1rel2spr3().getSprintBacklog().addTask(this.getPro1rel2spr3tas4());
		this.getPro1rel2spr3tas4().addPBI(this.getPro1rel2spr3fea4());
		this.getPro1rel2spr3tas4().setPlanEffort(new Effort(8));
		this.getPro1rel2spr3tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr3tas4().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr3tas4().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro1rel2spr3tas4().changeState(closedState);

		this.setPro1rel2spr3tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 3, Task 5",
				"Beschreibung von Task 5", this.getPro1rel2spr3().getSprintBacklog()));
		this.getPro1rel2spr3().getSprintBacklog().addTask(this.getPro1rel2spr3tas5());
		this.getPro1rel2spr3tas5().addPBI(this.getPro1rel2spr3fea5());
		this.getPro1rel2spr3tas5().setPlanEffort(new Effort(9));
		this.getPro1rel2spr3tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr3tas5().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr3tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro1rel2spr3tas5().changeState(closedState);

		// für Projekt 1, Release 2, Sprint 4
		this.setPro1rel2spr4tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 4, Task 1",
				"Beschreibung von Task 1", this.getPro1rel2spr4().getSprintBacklog()));
		this.getPro1rel2spr4().getSprintBacklog().addTask(this.getPro1rel2spr4tas1());
		this.getPro1rel2spr4tas1().addPBI(this.getPro1rel2spr4fea1());
		this.getPro1rel2spr4tas1().setPlanEffort(new Effort(1));
		this.getPro1rel2spr4tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr4tas1().setResponsibility(this.getpBjoern());
		// pro1rel2spr4tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr4tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 4, Task 2",
				"Beschreibung von Task 2", this.getPro1rel2spr4().getSprintBacklog()));
		this.getPro1rel2spr4().getSprintBacklog().addTask(this.getPro1rel2spr4tas2());
		this.getPro1rel2spr4tas2().addPBI(this.getPro1rel2spr4fea2());
		this.getPro1rel2spr4tas2().setPlanEffort(new Effort(2));
		this.getPro1rel2spr4tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr4tas2().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr4tas2().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro1rel2spr4tas2().changeState(closedState);

		this.setPro1rel2spr4tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 4, Task 3",
				"Beschreibung von Task 3", this.getPro1rel2spr4().getSprintBacklog()));
		this.getPro1rel2spr4().getSprintBacklog().addTask(this.getPro1rel2spr4tas3());
		this.getPro1rel2spr4tas3().addPBI(this.getPro1rel2spr4fea3());
		this.getPro1rel2spr4tas3().setPlanEffort(new Effort(6));
		this.getPro1rel2spr4tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr4tas3().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr4tas3().setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.getPro1rel2spr4tas3().changeState(closedState);

		this.setPro1rel2spr4tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 4, Task 4",
				"Beschreibung von Task 4", this.getPro1rel2spr4().getSprintBacklog()));
		this.getPro1rel2spr4().getSprintBacklog().addTask(this.getPro1rel2spr4tas4());
		this.getPro1rel2spr4tas4().addPBI(this.getPro1rel2spr4fea4());
		this.getPro1rel2spr4tas4().setPlanEffort(new Effort(1));
		this.getPro1rel2spr4tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr4tas4().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr4tas4().setFinishDate(new Date(2011 - 1900, 3 - 1, 3, 12, 0));
		this.getPro1rel2spr4tas4().changeState(closedState);

		this.setPro1rel2spr4tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 4, Task 5",
				"Beschreibung von Task 5", this.getPro1rel2spr4().getSprintBacklog()));
		this.getPro1rel2spr4().getSprintBacklog().addTask(this.getPro1rel2spr4tas5());
		this.getPro1rel2spr4tas5().addPBI(this.getPro1rel2spr4fea5());
		this.getPro1rel2spr4tas5().setPlanEffort(new Effort(3));
		this.getPro1rel2spr4tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr4tas5().setResponsibility(this.getpBjoern());
		this.getPro1rel2spr4tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.getPro1rel2spr4tas5().changeState(closedState);

		// für Projekt 1, Release 2, Sprint 5
		this.setPro1rel2spr5tas1(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 5, Task 1",
				"Beschreibung von Task 1", this.getPro1rel2spr5().getSprintBacklog()));
		this.getPro1rel2spr5().getSprintBacklog().addTask(this.getPro1rel2spr5tas1());
		this.getPro1rel2spr5tas1().addPBI(this.getPro1rel2spr5fea1());
		this.getPro1rel2spr5tas1().setPlanEffort(new Effort(8));
		this.getPro1rel2spr5tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr5tas1().setResponsibility(this.getpBjoern());
		// pro1rel2spr5tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr5tas2(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 5, Task 2",
				"Beschreibung von Task 2", this.getPro1rel2spr5().getSprintBacklog()));
		this.getPro1rel2spr5().getSprintBacklog().addTask(this.getPro1rel2spr5tas2());
		this.getPro1rel2spr5tas2().addPBI(this.getPro1rel2spr5fea2());
		this.getPro1rel2spr5tas2().setPlanEffort(new Effort(8));
		this.getPro1rel2spr5tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr5tas2().setResponsibility(this.getpBjoern());
		// pro1rel2spr5tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr5tas3(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 5, Task 3",
				"Beschreibung von Task 3", this.getPro1rel2spr5().getSprintBacklog()));
		this.getPro1rel2spr5().getSprintBacklog().addTask(this.getPro1rel2spr5tas3());
		this.getPro1rel2spr5tas3().addPBI(this.getPro1rel2spr5fea3());
		this.getPro1rel2spr5tas3().setPlanEffort(new Effort(8));
		this.getPro1rel2spr5tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr5tas3().setResponsibility(this.getpBjoern());
		// pro1rel2spr5tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr5tas4(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 5, Task 4",
				"Beschreibung von Task 4", this.getPro1rel2spr5().getSprintBacklog()));
		this.getPro1rel2spr5().getSprintBacklog().addTask(this.getPro1rel2spr5tas4());
		this.getPro1rel2spr5tas4().addPBI(this.getPro1rel2spr5fea4());
		this.getPro1rel2spr5tas4().setPlanEffort(new Effort(8));
		this.getPro1rel2spr5tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr5tas4().setResponsibility(this.getpBjoern());
		// pro1rel2spr5tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro1rel2spr5tas5(new Task(this.getModel(), taskTicketType, "Projekt 1, Release 2, Sprint 5, Task 5",
				"Beschreibung von Task 5", this.getPro1rel2spr5().getSprintBacklog()));
		this.getPro1rel2spr5().getSprintBacklog().addTask(this.getPro1rel2spr5tas5());
		this.getPro1rel2spr5tas5().addPBI(this.getPro1rel2spr5fea5());
		this.getPro1rel2spr5tas5().setPlanEffort(new Effort(8));
		this.getPro1rel2spr5tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro1rel2spr5tas5().setResponsibility(this.getpBjoern());
		// pro1rel2spr5tas5.getTicketType().getStateProfile().addEndState(closedState);

		// für Projekt 2, Release 1, Sprint 1
		this.setPro2rel1spr1tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 1, Task 1",
				"Beschreibung von Task 1", this.getPro2rel1spr1().getSprintBacklog()));
		this.getPro2rel1spr1().getSprintBacklog().addTask(this.getPro2rel1spr1tas1());
		this.getPro2rel1spr1tas1().addPBI(this.getPro2rel1spr1fea1());
		this.getPro2rel1spr1tas1().setPlanEffort(new Effort(7));
		this.getPro2rel1spr1tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr1tas1().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr1tas1().setFinishDate(new Date(2011 - 1900, 2 - 1, 1, 12, 0));
		this.getPro2rel1spr1tas1().changeState(closedState);

		this.setPro2rel1spr1tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 1, Task 2",
				"Beschreibung von Task 2", this.getPro2rel1spr1().getSprintBacklog()));
		this.getPro2rel1spr1().getSprintBacklog().addTask(this.getPro2rel1spr1tas2());
		this.getPro2rel1spr1tas2().addPBI(this.getPro2rel1spr1fea2());
		this.getPro2rel1spr1tas2().setPlanEffort(new Effort(3));
		this.getPro2rel1spr1tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr1tas2().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr1tas2().setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.getPro2rel1spr1tas2().changeState(closedState);

		this.setPro2rel1spr1tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 1, Task 3",
				"Beschreibung von Task 3", this.getPro2rel1spr1().getSprintBacklog()));
		this.getPro2rel1spr1().getSprintBacklog().addTask(this.getPro2rel1spr1tas3());
		this.getPro2rel1spr1tas3().addPBI(this.getPro2rel1spr1fea3());
		this.getPro2rel1spr1tas3().setPlanEffort(new Effort(3));
		this.getPro2rel1spr1tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr1tas3().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr1tas3().setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.getPro2rel1spr1tas3().changeState(closedState);

		this.setPro2rel1spr1tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 1, Task 4",
				"Beschreibung von Task 4", this.getPro2rel1spr1().getSprintBacklog()));
		this.getPro2rel1spr1().getSprintBacklog().addTask(this.getPro2rel1spr1tas4());
		this.getPro2rel1spr1tas4().addPBI(this.getPro2rel1spr1fea4());
		this.getPro2rel1spr1tas4().setPlanEffort(new Effort(5));
		this.getPro2rel1spr1tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr1tas4().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr1tas4().setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.getPro2rel1spr1tas4().changeState(closedState);

		this.setPro2rel1spr1tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 1, Task 5",
				"Beschreibung von Task 5", this.getPro2rel1spr1().getSprintBacklog()));
		this.getPro2rel1spr1().getSprintBacklog().addTask(this.getPro2rel1spr1tas5());
		this.getPro2rel1spr1tas5().addPBI(this.getPro2rel1spr1fea5());
		this.getPro2rel1spr1tas5().setPlanEffort(new Effort(4));
		this.getPro2rel1spr1tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr1tas5().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr1tas5().setFinishDate(new Date(2011 - 1900, 2 - 1, 1, 12, 0));
		this.getPro2rel1spr1tas5().changeState(closedState);

		// für Projekt 2, Release 1, Sprint 2
		this.setPro2rel1spr2tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 2, Task 1",
				"Beschreibung von Task 1", this.getPro2rel1spr2().getSprintBacklog()));
		this.getPro2rel1spr2().getSprintBacklog().addTask(this.getPro2rel1spr2tas1());
		this.getPro2rel1spr2tas1().addPBI(this.getPro2rel1spr2fea1());
		this.getPro2rel1spr2tas1().setPlanEffort(new Effort(3));
		this.getPro2rel1spr2tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr2tas1().setResponsibility(this.getpBjoern());
		// pro2rel1spr2tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel1spr2tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 2, Task 2",
				"Beschreibung von Task 2", this.getPro2rel1spr2().getSprintBacklog()));
		this.getPro2rel1spr2().getSprintBacklog().addTask(this.getPro2rel1spr2tas2());
		this.getPro2rel1spr2tas2().addPBI(this.getPro2rel1spr2fea2());
		this.getPro2rel1spr2tas2().setPlanEffort(new Effort(3));
		this.getPro2rel1spr2tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr2tas2().setResponsibility(this.getpBjoern());
		// pro2rel1spr2tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel1spr2tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 2, Task 3",
				"Beschreibung von Task 3", this.getPro2rel1spr2().getSprintBacklog()));
		this.getPro2rel1spr2().getSprintBacklog().addTask(this.getPro2rel1spr2tas3());
		this.getPro2rel1spr2tas3().addPBI(this.getPro2rel1spr2fea3());
		this.getPro2rel1spr2tas3().setPlanEffort(new Effort(3));
		this.getPro2rel1spr2tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr2tas3().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr2tas3().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro2rel1spr2tas3().changeState(closedState);

		this.setPro2rel1spr2tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 2, Task 4",
				"Beschreibung von Task 4", this.getPro2rel1spr2().getSprintBacklog()));
		this.getPro2rel1spr2().getSprintBacklog().addTask(this.getPro2rel1spr2tas4());
		this.getPro2rel1spr2tas4().addPBI(this.getPro2rel1spr2fea4());
		this.getPro2rel1spr2tas4().setPlanEffort(new Effort(3));
		this.getPro2rel1spr2tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr2tas4().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr2tas4().setFinishDate(new Date(2011 - 1900, 3 - 1, 15, 12, 0));
		this.getPro2rel1spr2tas4().changeState(closedState);

		this.setPro2rel1spr2tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 2, Task 5",
				"Beschreibung von Task 5", this.getPro2rel1spr2().getSprintBacklog()));
		this.getPro2rel1spr2().getSprintBacklog().addTask(this.getPro2rel1spr2tas5());
		this.getPro2rel1spr2tas5().addPBI(this.getPro2rel1spr2fea5());
		this.getPro2rel1spr2tas5().setPlanEffort(new Effort(3));
		this.getPro2rel1spr2tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr2tas5().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr2tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 30, 12, 0));
		this.getPro2rel1spr2tas5().changeState(closedState);

		// für Projekt 2, Release 1, Sprint 3
		this.setPro2rel1spr3tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 3, Task 1",
				"Beschreibung von Task 1", this.getPro2rel1spr3().getSprintBacklog()));
		this.getPro2rel1spr3().getSprintBacklog().addTask(this.getPro2rel1spr3tas1());
		this.getPro2rel1spr3tas1().addPBI(this.getPro2rel1spr3fea1());
		this.getPro2rel1spr3tas1().setPlanEffort(new Effort(3));
		this.getPro2rel1spr3tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr3tas1().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr3tas1().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro2rel1spr3tas1().changeState(closedState);

		this.setPro2rel1spr3tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 3, Task 2",
				"Beschreibung von Task 2", this.getPro2rel1spr3().getSprintBacklog()));
		this.getPro2rel1spr3().getSprintBacklog().addTask(this.getPro2rel1spr3tas2());
		this.getPro2rel1spr3tas2().addPBI(this.getPro2rel1spr3fea2());
		this.getPro2rel1spr3tas2().setPlanEffort(new Effort(6));
		this.getPro2rel1spr3tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr3tas2().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr3tas2().setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.getPro2rel1spr3tas2().changeState(closedState);

		this.setPro2rel1spr3tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 3, Task 3",
				"Beschreibung von Task 3", this.getPro2rel1spr3().getSprintBacklog()));
		this.getPro2rel1spr3().getSprintBacklog().addTask(this.getPro2rel1spr3tas3());
		this.getPro2rel1spr3tas3().addPBI(this.getPro2rel1spr3fea3());
		this.getPro2rel1spr3tas3().setPlanEffort(new Effort(2));
		this.getPro2rel1spr3tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr3tas3().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr3tas3().setFinishDate(new Date(2011 - 1900, 4 - 1, 1, 12, 0));
		this.getPro2rel1spr3tas3().changeState(closedState);

		this.setPro2rel1spr3tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 3, Task 4",
				"Beschreibung von Task 4", this.getPro2rel1spr3().getSprintBacklog()));
		this.getPro2rel1spr3().getSprintBacklog().addTask(this.getPro2rel1spr3tas4());
		this.getPro2rel1spr3tas4().addPBI(this.getPro2rel1spr3fea4());
		this.getPro2rel1spr3tas4().setPlanEffort(new Effort(3));
		this.getPro2rel1spr3tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr3tas4().setResponsibility(this.getpBjoern());
		// pro2rel1spr3tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel1spr3tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 3, Task 5",
				"Beschreibung von Task 5", this.getPro2rel1spr3().getSprintBacklog()));
		this.getPro2rel1spr3().getSprintBacklog().addTask(this.getPro2rel1spr3tas5());
		this.getPro2rel1spr3tas5().addPBI(this.getPro2rel1spr3fea5());
		this.getPro2rel1spr3tas5().setPlanEffort(new Effort(6));
		this.getPro2rel1spr3tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr3tas5().setResponsibility(this.getpBjoern());
		// pro2rel1spr3tas5.getTicketType().getStateProfile().addEndState(closedState);

		// für Projekt 2, Release 1, Sprint 4
		this.setPro2rel1spr4tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 4, Task 1",
				"Beschreibung von Task 1", this.getPro2rel1spr4().getSprintBacklog()));
		this.getPro2rel1spr4().getSprintBacklog().addTask(this.getPro2rel1spr4tas1());
		this.getPro2rel1spr4tas1().addPBI(this.getPro2rel1spr4fea1());
		this.getPro2rel1spr4tas1().setPlanEffort(new Effort(4));
		this.getPro2rel1spr4tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr4tas1().setResponsibility(this.getpBjoern());
		// pro2rel1spr4tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel1spr4tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 4, Task 2",
				"Beschreibung von Task 2", this.getPro2rel1spr4().getSprintBacklog()));
		this.getPro2rel1spr4().getSprintBacklog().addTask(this.getPro2rel1spr4tas2());
		this.getPro2rel1spr4tas2().addPBI(this.getPro2rel1spr4fea2());
		this.getPro2rel1spr4tas2().setPlanEffort(new Effort(6));
		this.getPro2rel1spr4tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr4tas2().setResponsibility(this.getpBjoern());
		// pro2rel1spr4tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel1spr4tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 4, Task 3",
				"Beschreibung von Task 3", this.getPro2rel1spr4().getSprintBacklog()));
		this.getPro2rel1spr4().getSprintBacklog().addTask(this.getPro2rel1spr4tas3());
		this.getPro2rel1spr4tas3().addPBI(this.getPro2rel1spr4fea3());
		this.getPro2rel1spr4tas3().setPlanEffort(new Effort(7));
		this.getPro2rel1spr4tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr4tas3().setResponsibility(this.getpBjoern());
		// pro2rel1spr4tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel1spr4tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 4, Task 4",
				"Beschreibung von Task 4", this.getPro2rel1spr4().getSprintBacklog()));
		this.getPro2rel1spr4().getSprintBacklog().addTask(this.getPro2rel1spr4tas4());
		this.getPro2rel1spr4tas4().addPBI(this.getPro2rel1spr4fea4());
		this.getPro2rel1spr4tas4().setPlanEffort(new Effort(8));
		this.getPro2rel1spr4tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr4tas4().setResponsibility(this.getpBjoern());
		// pro2rel1spr4tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel1spr4tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 4, Task 5",
				"Beschreibung von Task 5", this.getPro2rel1spr4().getSprintBacklog()));
		this.getPro2rel1spr4().getSprintBacklog().addTask(this.getPro2rel1spr4tas5());
		this.getPro2rel1spr4tas5().addPBI(this.getPro2rel1spr4fea5());
		this.getPro2rel1spr4tas5().setPlanEffort(new Effort(1));
		this.getPro2rel1spr4tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr4tas5().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr4tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 17, 12, 0));
		this.getPro2rel1spr4tas5().changeState(closedState);

		// für Projekt 2, Release 1, Sprint 5
		this.setPro2rel1spr5tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 5, Task 1",
				"Beschreibung von Task 1", this.getPro2rel1spr5().getSprintBacklog()));
		this.getPro2rel1spr5().getSprintBacklog().addTask(this.getPro2rel1spr5tas1());
		this.getPro2rel1spr5tas1().addPBI(this.getPro2rel1spr5fea1());
		this.getPro2rel1spr5tas1().setPlanEffort(new Effort(2));
		this.getPro2rel1spr5tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr5tas1().setResponsibility(this.getpBjoern());
		// pro2rel1spr5tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel1spr5tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 5, Task 2",
				"Beschreibung von Task 2", this.getPro2rel1spr5().getSprintBacklog()));
		this.getPro2rel1spr5().getSprintBacklog().addTask(this.getPro2rel1spr5tas2());
		this.getPro2rel1spr5tas2().addPBI(this.getPro2rel1spr5fea2());
		this.getPro2rel1spr5tas2().setPlanEffort(new Effort(8));
		this.getPro2rel1spr5tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr5tas2().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr5tas2().setFinishDate(new Date(2011 - 1900, 3 - 1, 14, 12, 0));
		this.getPro2rel1spr5tas2().changeState(closedState);

		this.setPro2rel1spr5tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 5, Task 3",
				"Beschreibung von Task 3", this.getPro2rel1spr5().getSprintBacklog()));
		this.getPro2rel1spr5().getSprintBacklog().addTask(this.getPro2rel1spr5tas3());
		this.getPro2rel1spr5tas3().addPBI(this.getPro2rel1spr5fea3());
		this.getPro2rel1spr5tas3().setPlanEffort(new Effort(3));
		this.getPro2rel1spr5tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr5tas3().setResponsibility(this.getpBjoern());
		// pro2rel1spr5tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel1spr5tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 5, Task 4",
				"Beschreibung von Task 4", this.getPro2rel1spr5().getSprintBacklog()));
		this.getPro2rel1spr5().getSprintBacklog().addTask(this.getPro2rel1spr5tas4());
		this.getPro2rel1spr5tas4().addPBI(this.getPro2rel1spr5fea4());
		this.getPro2rel1spr5tas4().setPlanEffort(new Effort(5));
		this.getPro2rel1spr5tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr5tas4().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr5tas4().setFinishDate(new Date(2011 - 1900, 3 - 1, 14, 12, 0));
		this.getPro2rel1spr5tas4().changeState(closedState);

		this.setPro2rel1spr5tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 1, Sprint 5, Task 5",
				"Beschreibung von Task 5", this.getPro2rel1spr5().getSprintBacklog()));
		this.getPro2rel1spr5().getSprintBacklog().addTask(this.getPro2rel1spr5tas5());
		this.getPro2rel1spr5tas5().addPBI(this.getPro2rel1spr5fea5());
		this.getPro2rel1spr5tas5().setPlanEffort(new Effort(3));
		this.getPro2rel1spr5tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel1spr5tas5().setResponsibility(this.getpBjoern());
		this.getPro2rel1spr5tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 7, 12, 0));
		this.getPro2rel1spr5tas5().changeState(closedState);

		// für Projekt 2, Release 2, Sprint 1
		this.setPro2rel2spr1tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 1, Task 1",
				"Beschreibung von Task 1", this.getPro2rel2spr1().getSprintBacklog()));
		this.getPro2rel2spr1().getSprintBacklog().addTask(this.getPro2rel2spr1tas1());
		this.getPro2rel2spr1tas1().addPBI(this.getPro2rel2spr1fea1());
		this.getPro2rel2spr1tas1().setPlanEffort(new Effort(5));
		this.getPro2rel2spr1tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr1tas1().setResponsibility(this.getpBjoern());
		// pro2rel2spr1tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel2spr1tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 1, Task 2",
				"Beschreibung von Task 2", this.getPro2rel2spr1().getSprintBacklog()));
		this.getPro2rel2spr1().getSprintBacklog().addTask(this.getPro2rel2spr1tas2());
		this.getPro2rel2spr1tas2().addPBI(this.getPro2rel2spr1fea2());
		this.getPro2rel2spr1tas2().setPlanEffort(new Effort(5));
		this.getPro2rel2spr1tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr1tas2().setResponsibility(this.getpBjoern());
		// pro2rel2spr1tas2.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel2spr1tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 1, Task 3",
				"Beschreibung von Task 3", this.getPro2rel2spr1().getSprintBacklog()));
		this.getPro2rel2spr1().getSprintBacklog().addTask(this.getPro2rel2spr1tas3());
		this.getPro2rel2spr1tas3().addPBI(this.getPro2rel2spr1fea3());
		this.getPro2rel2spr1tas3().setPlanEffort(new Effort(5));
		this.getPro2rel2spr1tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr1tas3().setResponsibility(this.getpBjoern());
		// pro2rel2spr1tas3.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel2spr1tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 1, Task 4",
				"Beschreibung von Task 4", this.getPro2rel2spr1().getSprintBacklog()));
		this.getPro2rel2spr1().getSprintBacklog().addTask(this.getPro2rel2spr1tas4());
		this.getPro2rel2spr1tas4().addPBI(this.getPro2rel2spr1fea4());
		this.getPro2rel2spr1tas4().setPlanEffort(new Effort(5));
		this.getPro2rel2spr1tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr1tas4().setResponsibility(this.getpBjoern());
		// pro2rel2spr1tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel2spr1tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 1, Task 5",
				"Beschreibung von Task 5", this.getPro2rel2spr1().getSprintBacklog()));
		this.getPro2rel2spr1().getSprintBacklog().addTask(this.getPro2rel2spr1tas5());
		this.getPro2rel2spr1tas5().addPBI(this.getPro2rel2spr1fea5());
		this.getPro2rel2spr1tas5().setPlanEffort(new Effort(5));
		this.getPro2rel2spr1tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr1tas5().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr1tas5().setFinishDate(new Date(2011 - 1900, 6 - 1, 13, 12, 0));
		this.getPro2rel2spr1tas5().changeState(closedState);

		// für Projekt 2, Release 2, Sprint 2
		this.setPro2rel2spr2tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 2, Task 1",
				"Beschreibung von Task 1", this.getPro2rel2spr2().getSprintBacklog()));
		this.getPro2rel2spr2().getSprintBacklog().addTask(this.getPro2rel2spr2tas1());
		this.getPro2rel2spr2tas1().addPBI(this.getPro2rel2spr2fea1());
		this.getPro2rel2spr2tas1().setPlanEffort(new Effort(5));
		this.getPro2rel2spr2tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr2tas1().setResponsibility(this.getpBjoern());
		// pro2rel2spr2tas1.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel2spr2tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 2, Task 2",
				"Beschreibung von Task 2", this.getPro2rel2spr2().getSprintBacklog()));
		this.getPro2rel2spr2().getSprintBacklog().addTask(this.getPro2rel2spr2tas2());
		this.getPro2rel2spr2tas2().addPBI(this.getPro2rel2spr2fea2());
		this.getPro2rel2spr2tas2().setPlanEffort(new Effort(5));
		this.getPro2rel2spr2tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr2tas2().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr2tas2().setFinishDate(new Date(2011 - 1900, 2 - 1, 11, 12, 0));
		this.getPro2rel2spr2tas2().changeState(closedState);

		this.setPro2rel2spr2tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 2, Task 3",
				"Beschreibung von Task 3", this.getPro2rel2spr2().getSprintBacklog()));
		this.getPro2rel2spr2().getSprintBacklog().addTask(this.getPro2rel2spr2tas3());
		this.getPro2rel2spr2tas3().addPBI(this.getPro2rel2spr2fea3());
		this.getPro2rel2spr2tas3().setPlanEffort(new Effort(5));
		this.getPro2rel2spr2tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr2tas3().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr2tas3().setFinishDate(new Date(2011 - 1900, 2 - 1, 12, 12, 0));
		this.getPro2rel2spr2tas3().changeState(closedState);

		this.setPro2rel2spr2tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 2, Task 4",
				"Beschreibung von Task 4", this.getPro2rel2spr2().getSprintBacklog()));
		this.getPro2rel2spr2().getSprintBacklog().addTask(this.getPro2rel2spr2tas4());
		this.getPro2rel2spr2tas4().addPBI(this.getPro2rel2spr2fea4());
		this.getPro2rel2spr2tas4().setPlanEffort(new Effort(5));
		this.getPro2rel2spr2tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr2tas4().setResponsibility(this.getpBjoern());
		// pro2rel2spr2tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel2spr2tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 2, Task 5",
				"Beschreibung von Task 5", this.getPro2rel2spr2().getSprintBacklog()));
		this.getPro2rel2spr2().getSprintBacklog().addTask(this.getPro2rel2spr2tas5());
		this.getPro2rel2spr2tas5().addPBI(this.getPro2rel2spr2fea5());
		this.getPro2rel2spr2tas5().setPlanEffort(new Effort(5));
		this.getPro2rel2spr2tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr2tas5().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr2tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro2rel2spr2tas5().changeState(closedState);

		// für Projekt 2, Release 2, Sprint 3
		this.setPro2rel2spr3tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 3, Task 1",
				"Beschreibung von Task 1", this.getPro2rel2spr3().getSprintBacklog()));
		this.getPro2rel2spr3().getSprintBacklog().addTask(this.getPro2rel2spr3tas1());
		this.getPro2rel2spr3tas1().addPBI(this.getPro2rel2spr3fea1());
		this.getPro2rel2spr3tas1().setPlanEffort(new Effort(5));
		this.getPro2rel2spr3tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr3tas1().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr3tas1().setFinishDate(new Date(2011 - 1900, 1 - 1, 1, 12, 0));
		this.getPro2rel2spr3tas1().changeState(closedState);

		this.setPro2rel2spr3tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 3, Task 2",
				"Beschreibung von Task 2", this.getPro2rel2spr3().getSprintBacklog()));
		this.getPro2rel2spr3().getSprintBacklog().addTask(this.getPro2rel2spr3tas2());
		this.getPro2rel2spr3tas2().addPBI(this.getPro2rel2spr3fea2());
		this.getPro2rel2spr3tas2().setPlanEffort(new Effort(5));
		this.getPro2rel2spr3tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr3tas2().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr3tas2().setFinishDate(new Date(2011 - 1900, 1 - 1, 2, 12, 0));
		this.getPro2rel2spr3tas2().changeState(closedState);

		this.setPro2rel2spr3tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 3, Task 3",
				"Beschreibung von Task 3", this.getPro2rel2spr3().getSprintBacklog()));
		this.getPro2rel2spr3().getSprintBacklog().addTask(this.getPro2rel2spr3tas3());
		this.getPro2rel2spr3tas3().addPBI(this.getPro2rel2spr3fea3());
		this.getPro2rel2spr3tas3().setPlanEffort(new Effort(5));
		this.getPro2rel2spr3tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr3tas3().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr3tas3().setFinishDate(new Date(2011 - 1900, 1 - 1, 11, 12, 0));
		this.getPro2rel2spr3tas3().changeState(closedState);

		this.setPro2rel2spr3tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 3, Task 4",
				"Beschreibung von Task 4", this.getPro2rel2spr3().getSprintBacklog()));
		this.getPro2rel2spr3().getSprintBacklog().addTask(this.getPro2rel2spr3tas4());
		this.getPro2rel2spr3tas4().addPBI(this.getPro2rel2spr3fea4());
		this.getPro2rel2spr3tas4().setPlanEffort(new Effort(5));
		this.getPro2rel2spr3tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr3tas4().setResponsibility(this.getpBjoern());
		// pro2rel2spr3tas4.getTicketType().getStateProfile().addEndState(closedState);

		this.setPro2rel2spr3tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 3, Task 5",
				"Beschreibung von Task 5", this.getPro2rel2spr3().getSprintBacklog()));
		this.getPro2rel2spr3().getSprintBacklog().addTask(this.getPro2rel2spr3tas5());
		this.getPro2rel2spr3tas5().addPBI(this.getPro2rel2spr3fea5());
		this.getPro2rel2spr3tas5().setPlanEffort(new Effort(5));
		this.getPro2rel2spr3tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr3tas5().setResponsibility(this.getpBjoern());
		// pro2rel2spr3tas5.getTicketType().getStateProfile().addEndState(closedState);

		// für Projekt 2, Release 2, Sprint 4
		this.setPro2rel2spr4tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 4, Task 1",
				"Beschreibung von Task 1", this.getPro2rel2spr4().getSprintBacklog()));
		this.getPro2rel2spr4().getSprintBacklog().addTask(this.getPro2rel2spr4tas1());
		this.getPro2rel2spr4tas1().addPBI(this.getPro2rel2spr4fea1());
		this.getPro2rel2spr4tas1().setPlanEffort(new Effort(5));
		this.getPro2rel2spr4tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr4tas1().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr4tas1().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro2rel2spr4tas1().changeState(closedState);

		this.setPro2rel2spr4tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 4, Task 2",
				"Beschreibung von Task 2", this.getPro2rel2spr4().getSprintBacklog()));
		this.getPro2rel2spr4().getSprintBacklog().addTask(this.getPro2rel2spr4tas2());
		this.getPro2rel2spr4tas2().addPBI(this.getPro2rel2spr4fea2());
		this.getPro2rel2spr4tas2().setPlanEffort(new Effort(5));
		this.getPro2rel2spr4tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr4tas2().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr4tas2().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro2rel2spr4tas2().changeState(closedState);

		this.setPro2rel2spr4tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 4, Task 3",
				"Beschreibung von Task 3", this.getPro2rel2spr4().getSprintBacklog()));
		this.getPro2rel2spr4().getSprintBacklog().addTask(this.getPro2rel2spr4tas3());
		this.getPro2rel2spr4tas3().addPBI(this.getPro2rel2spr4fea3());
		this.getPro2rel2spr4tas3().setPlanEffort(new Effort(5));
		this.getPro2rel2spr4tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr4tas3().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr4tas3().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro2rel2spr4tas3().changeState(closedState);

		this.setPro2rel2spr4tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 4, Task 4",
				"Beschreibung von Task 4", this.getPro2rel2spr4().getSprintBacklog()));
		this.getPro2rel2spr4().getSprintBacklog().addTask(this.getPro2rel2spr4tas4());
		this.getPro2rel2spr4tas4().addPBI(this.getPro2rel2spr4fea4());
		this.getPro2rel2spr4tas4().setPlanEffort(new Effort(5));
		this.getPro2rel2spr4tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr4tas4().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr4tas4().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro2rel2spr4tas4().changeState(closedState);

		this.setPro2rel2spr4tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 4, Task 5",
				"Beschreibung von Task 5", this.getPro2rel2spr4().getSprintBacklog()));
		this.getPro2rel2spr4().getSprintBacklog().addTask(this.getPro2rel2spr4tas5());
		this.getPro2rel2spr4tas5().addPBI(this.getPro2rel2spr4fea5());
		this.getPro2rel2spr4tas5().setPlanEffort(new Effort(5));
		this.getPro2rel2spr4tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr4tas5().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr4tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 1, 12, 0));
		this.getPro2rel2spr4tas5().changeState(closedState);

		// für Projekt 2, Release 2, Sprint 5
		this.setPro2rel2spr5tas1(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 5, Task 1",
				"Beschreibung von Task 1", this.getPro2rel2spr5().getSprintBacklog()));
		this.getPro2rel2spr5().getSprintBacklog().addTask(this.getPro2rel2spr5tas1());
		this.getPro2rel2spr5tas1().addPBI(this.getPro2rel2spr5fea1());
		this.getPro2rel2spr5tas1().setPlanEffort(new Effort(5));
		this.getPro2rel2spr5tas1().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr5tas1().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr5tas1().setFinishDate(new Date(2011 - 1900, 2 - 1, 27, 12, 0));
		this.getPro2rel2spr5tas1().changeState(closedState);

		this.setPro2rel2spr5tas2(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 5, Task 2",
				"Beschreibung von Task 2", this.getPro2rel2spr5().getSprintBacklog()));
		this.getPro2rel2spr5().getSprintBacklog().addTask(this.getPro2rel2spr5tas2());
		this.getPro2rel2spr5tas2().addPBI(this.getPro2rel2spr5fea2());
		this.getPro2rel2spr5tas2().setPlanEffort(new Effort(5));
		this.getPro2rel2spr5tas2().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr5tas2().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr5tas2().setFinishDate(new Date(2011 - 1900, 2 - 1, 27, 12, 0));
		this.getPro2rel2spr5tas2().changeState(closedState);

		this.setPro2rel2spr5tas3(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 5, Task 3",
				"Beschreibung von Task 3", this.getPro2rel2spr5().getSprintBacklog()));
		this.getPro2rel2spr5().getSprintBacklog().addTask(this.getPro2rel2spr5tas3());
		this.getPro2rel2spr5tas3().addPBI(this.getPro2rel2spr5fea3());
		this.getPro2rel2spr5tas3().setPlanEffort(new Effort(5));
		this.getPro2rel2spr5tas3().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr5tas3().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr5tas3().setFinishDate(new Date(2011 - 1900, 3 - 1, 2, 12, 0));
		this.getPro2rel2spr5tas3().changeState(closedState);

		this.setPro2rel2spr5tas4(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 5, Task 4",
				"Beschreibung von Task 4", this.getPro2rel2spr5().getSprintBacklog()));
		this.getPro2rel2spr5().getSprintBacklog().addTask(this.getPro2rel2spr5tas4());
		this.getPro2rel2spr5tas4().addPBI(this.getPro2rel2spr5fea4());
		this.getPro2rel2spr5tas4().setPlanEffort(new Effort(5));
		this.getPro2rel2spr5tas4().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr5tas4().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr5tas4().setFinishDate(new Date(2011 - 1900, 3 - 1, 3, 12, 0));
		this.getPro2rel2spr5tas4().changeState(closedState);

		this.setPro2rel2spr5tas5(new Task(this.getModel(), taskTicketType, "Projekt 2, Release 2, Sprint 5, Task 5",
				"Beschreibung von Task 5", this.getPro2rel2spr5().getSprintBacklog()));
		this.getPro2rel2spr5().getSprintBacklog().addTask(this.getPro2rel2spr5tas5());
		this.getPro2rel2spr5tas5().addPBI(this.getPro2rel2spr5fea5());
		this.getPro2rel2spr5tas5().setPlanEffort(new Effort(5));
		this.getPro2rel2spr5tas5().changeState(this.getModel().getTypeManager().getInProcess());
		this.getPro2rel2spr5tas5().setResponsibility(this.getpBjoern());
		this.getPro2rel2spr5tas5().setFinishDate(new Date(2011 - 1900, 3 - 1, 7, 12, 0));
		this.getPro2rel2spr5tas5().changeState(closedState);

		this.setListOfFeatures(new ArrayList<ProductBacklogItem>());
		this.getListOfFeatures().add(this.getPro1rel2spr1fea1());
		this.getListOfFeatures().add(this.getPro1rel1spr5fea5());
		this.getListOfFeatures().add(this.getPro1rel1spr1fea1());
		this.getListOfFeatures().add(this.getPro1rel1spr1fea2());
		this.getListOfFeatures().add(this.getPro1rel1spr1fea3());
		this.getListOfFeatures().add(this.getPro1rel1spr1fea4());
		this.getListOfFeatures().add(this.getPro1rel1spr1fea5());
		this.getListOfFeatures().add(this.getPro1rel1spr2fea1());
		this.getListOfFeatures().add(this.getPro1rel1spr2fea2());
		this.getListOfFeatures().add(this.getPro1rel1spr2fea3());
		this.getListOfFeatures().add(this.getPro1rel1spr2fea4());
		this.getListOfFeatures().add(this.getPro1rel1spr2fea5());
		this.getListOfFeatures().add(this.getPro1rel1spr3fea1());
		this.getListOfFeatures().add(this.getPro1rel1spr3fea2());
		this.getListOfFeatures().add(this.getPro1rel1spr3fea3());
		this.getListOfFeatures().add(this.getPro1rel1spr3fea4());
		this.getListOfFeatures().add(this.getPro1rel1spr3fea5());
		this.getListOfFeatures().add(this.getPro1rel1spr4fea1());
		this.getListOfFeatures().add(this.getPro1rel1spr4fea2());
		this.getListOfFeatures().add(this.getPro1rel1spr4fea3());
		this.getListOfFeatures().add(this.getPro1rel1spr4fea4());
		this.getListOfFeatures().add(this.getPro1rel1spr4fea5());
		this.getListOfFeatures().add(this.getPro1rel1spr5fea1());
		this.getListOfFeatures().add(this.getPro1rel1spr5fea2());
		this.getListOfFeatures().add(this.getPro1rel1spr5fea3());
		this.getListOfFeatures().add(this.getPro1rel1spr5fea4());
		this.getListOfFeatures().add(this.getPro1rel2spr1fea2());
		this.getListOfFeatures().add(this.getPro1rel2spr1fea3());
		this.getListOfFeatures().add(this.getPro1rel2spr1fea4());
		this.getListOfFeatures().add(this.getPro1rel2spr1fea5());
		this.getListOfFeatures().add(this.getPro1rel2spr2fea1());
		this.getListOfFeatures().add(this.getPro1rel2spr2fea2());
		this.getListOfFeatures().add(this.getPro1rel2spr2fea3());
		this.getListOfFeatures().add(this.getPro1rel2spr2fea4());
		this.getListOfFeatures().add(this.getPro1rel2spr2fea5());
		this.getListOfFeatures().add(this.getPro1rel2spr3fea1());
		this.getListOfFeatures().add(this.getPro1rel2spr3fea2());
		this.getListOfFeatures().add(this.getPro1rel2spr3fea3());
		this.getListOfFeatures().add(this.getPro1rel2spr3fea4());
		this.getListOfFeatures().add(this.getPro1rel2spr3fea5());
		this.getListOfFeatures().add(this.getPro1rel2spr4fea1());
		this.getListOfFeatures().add(this.getPro1rel2spr4fea2());
		this.getListOfFeatures().add(this.getPro1rel2spr4fea3());
		this.getListOfFeatures().add(this.getPro1rel2spr4fea4());
		this.getListOfFeatures().add(this.getPro1rel2spr4fea5());
		this.getListOfFeatures().add(this.getPro1rel2spr5fea1());
		this.getListOfFeatures().add(this.getPro1rel2spr5fea2());
		this.getListOfFeatures().add(this.getPro1rel2spr5fea3());
		this.getListOfFeatures().add(this.getPro1rel2spr5fea4());
		this.getListOfFeatures().add(this.getPro1rel2spr5fea5());
		this.getListOfFeatures().add(this.getPro2rel1spr1fea1());
		this.getListOfFeatures().add(this.getPro2rel1spr1fea2());
		this.getListOfFeatures().add(this.getPro2rel1spr1fea3());
		this.getListOfFeatures().add(this.getPro2rel1spr1fea4());
		this.getListOfFeatures().add(this.getPro2rel1spr1fea5());
		this.getListOfFeatures().add(this.getPro2rel1spr2fea1());
		this.getListOfFeatures().add(this.getPro2rel1spr2fea2());
		this.getListOfFeatures().add(this.getPro2rel1spr2fea3());
		this.getListOfFeatures().add(this.getPro2rel1spr2fea4());
		this.getListOfFeatures().add(this.getPro2rel1spr2fea5());
		this.getListOfFeatures().add(this.getPro2rel1spr3fea1());
		this.getListOfFeatures().add(this.getPro2rel1spr3fea2());
		this.getListOfFeatures().add(this.getPro2rel1spr3fea3());
		this.getListOfFeatures().add(this.getPro2rel1spr3fea4());
		this.getListOfFeatures().add(this.getPro2rel1spr3fea5());
		this.getListOfFeatures().add(this.getPro2rel1spr4fea1());
		this.getListOfFeatures().add(this.getPro2rel1spr4fea2());
		this.getListOfFeatures().add(this.getPro2rel1spr4fea3());
		this.getListOfFeatures().add(this.getPro2rel1spr4fea4());
		this.getListOfFeatures().add(this.getPro2rel1spr4fea5());
		this.getListOfFeatures().add(this.getPro2rel1spr5fea1());
		this.getListOfFeatures().add(this.getPro2rel1spr5fea2());
		this.getListOfFeatures().add(this.getPro2rel1spr5fea3());
		this.getListOfFeatures().add(this.getPro2rel1spr5fea4());
		this.getListOfFeatures().add(this.getPro2rel1spr5fea5());
		this.getListOfFeatures().add(this.getPro2rel2spr1fea1());
		this.getListOfFeatures().add(this.getPro2rel2spr1fea2());
		this.getListOfFeatures().add(this.getPro2rel2spr1fea3());
		this.getListOfFeatures().add(this.getPro2rel2spr1fea4());
		this.getListOfFeatures().add(this.getPro2rel2spr1fea5());
		this.getListOfFeatures().add(this.getPro2rel2spr2fea1());
		this.getListOfFeatures().add(this.getPro2rel2spr2fea2());
		this.getListOfFeatures().add(this.getPro2rel2spr2fea3());
		this.getListOfFeatures().add(this.getPro2rel2spr2fea4());
		this.getListOfFeatures().add(this.getPro2rel2spr2fea5());
		this.getListOfFeatures().add(this.getPro2rel2spr3fea1());
		this.getListOfFeatures().add(this.getPro2rel2spr3fea2());
		this.getListOfFeatures().add(this.getPro2rel2spr3fea3());
		this.getListOfFeatures().add(this.getPro2rel2spr3fea4());
		this.getListOfFeatures().add(this.getPro2rel2spr3fea5());
		this.getListOfFeatures().add(this.getPro2rel2spr4fea1());
		this.getListOfFeatures().add(this.getPro2rel2spr4fea2());
		this.getListOfFeatures().add(this.getPro2rel2spr4fea3());
		this.getListOfFeatures().add(this.getPro2rel2spr4fea4());
		this.getListOfFeatures().add(this.getPro2rel2spr4fea5());
		this.getListOfFeatures().add(this.getPro2rel2spr5fea1());
		this.getListOfFeatures().add(this.getPro2rel2spr5fea2());
		this.getListOfFeatures().add(this.getPro2rel2spr5fea3());
		this.getListOfFeatures().add(this.getPro2rel2spr5fea4());
		this.getListOfFeatures().add(this.getPro2rel2spr5fea5());

		this.getPro1rel1().addSprint(this.getPro1rel1spr1());
		this.getPro1rel1().addSprint(this.getPro1rel1spr2());
		this.getPro1rel1().addSprint(this.getPro1rel1spr3());
		this.getPro1rel1().addSprint(this.getPro1rel1spr4());
		this.getPro1rel1().addSprint(this.getPro1rel1spr5());
		this.getPro1rel2().addSprint(this.getPro1rel2spr1());
		this.getPro1rel2().addSprint(this.getPro1rel2spr2());
		this.getPro1rel2().addSprint(this.getPro1rel2spr3());
		this.getPro1rel2().addSprint(this.getPro1rel2spr4());
		this.getPro1rel2().addSprint(this.getPro1rel2spr5());
		this.getPro2rel1().addSprint(this.getPro2rel1spr1());
		this.getPro2rel1().addSprint(this.getPro2rel1spr2());
		this.getPro2rel1().addSprint(this.getPro2rel1spr3());
		this.getPro2rel1().addSprint(this.getPro2rel1spr4());
		this.getPro2rel1().addSprint(this.getPro2rel1spr5());
		this.getPro2rel2().addSprint(this.getPro2rel2spr1());
		this.getPro2rel2().addSprint(this.getPro2rel2spr2());
		this.getPro2rel2().addSprint(this.getPro2rel2spr3());
		this.getPro2rel2().addSprint(this.getPro2rel2spr4());
		this.getPro2rel2().addSprint(this.getPro2rel2spr5());
		this.getPro3rel1().addSprint(this.getPro3rel1spr1());
		this.getPro3rel1().addSprint(this.getPro3rel1spr2());
		this.getPro3rel1().addSprint(this.getPro3rel1spr3());
		this.getPro3rel1().addSprint(this.getPro3rel1spr4());
		this.getPro3rel1().addSprint(this.getPro3rel1spr5());
		this.getPro3rel2().addSprint(this.getPro3rel2spr1());
		this.getPro3rel2().addSprint(this.getPro3rel2spr2());
		this.getPro3rel2().addSprint(this.getPro3rel2spr3());
		this.getPro3rel2().addSprint(this.getPro3rel2spr4());
		this.getPro3rel2().addSprint(this.getPro3rel2spr5());
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(final Model model) {
		this.model = model;
	}

	/**
	 * @param pro1rel2spr1fea1
	 *            the pro1rel2spr1fea1 to set
	 */
	public void setPro1rel2spr1fea1(final Feature pro1rel2spr1fea1) {
		this.pro1rel2spr1fea1 = pro1rel2spr1fea1;
	}

	/**
	 * @return the pro1rel2spr1fea1
	 */
	protected Feature getPro1rel2spr1fea1() {
		return this.pro1rel2spr1fea1;
	}

	/**
	 * @param pro1rel1spr5fea5
	 *            the pro1rel1spr5fea5 to set
	 */
	public void setPro1rel1spr5fea5(final Feature pro1rel1spr5fea5) {
		this.pro1rel1spr5fea5 = pro1rel1spr5fea5;
	}

	/**
	 * @return the pro1rel1spr5fea5
	 */
	public Feature getPro1rel1spr5fea5() {
		return this.pro1rel1spr5fea5;
	}

	/**
	 * @param pro1rel1spr1fea1
	 *            the pro1rel1spr1fea1 to set
	 */
	public void setPro1rel1spr1fea1(final Feature pro1rel1spr1fea1) {
		this.pro1rel1spr1fea1 = pro1rel1spr1fea1;
	}

	/**
	 * @return the pro1rel1spr1fea1
	 */
	public Feature getPro1rel1spr1fea1() {
		return this.pro1rel1spr1fea1;
	}

	/**
	 * @param pro1rel1spr1fea2
	 *            the pro1rel1spr1fea2 to set
	 */
	public void setPro1rel1spr1fea2(final Feature pro1rel1spr1fea2) {
		this.pro1rel1spr1fea2 = pro1rel1spr1fea2;
	}

	/**
	 * @return the pro1rel1spr1fea2
	 */
	public Feature getPro1rel1spr1fea2() {
		return this.pro1rel1spr1fea2;
	}

	/**
	 * @param pro1rel1spr1fea3
	 *            the pro1rel1spr1fea3 to set
	 */
	public void setPro1rel1spr1fea3(final Feature pro1rel1spr1fea3) {
		this.pro1rel1spr1fea3 = pro1rel1spr1fea3;
	}

	/**
	 * @return the pro1rel1spr1fea3
	 */
	public Feature getPro1rel1spr1fea3() {
		return this.pro1rel1spr1fea3;
	}

	/**
	 * @param pro1rel1spr1fea4
	 *            the pro1rel1spr1fea4 to set
	 */
	public void setPro1rel1spr1fea4(final Feature pro1rel1spr1fea4) {
		this.pro1rel1spr1fea4 = pro1rel1spr1fea4;
	}

	/**
	 * @return the pro1rel1spr1fea4
	 */
	public Feature getPro1rel1spr1fea4() {
		return this.pro1rel1spr1fea4;
	}

	/**
	 * @param pro1rel1spr1fea5
	 *            the pro1rel1spr1fea5 to set
	 */
	public void setPro1rel1spr1fea5(final Feature pro1rel1spr1fea5) {
		this.pro1rel1spr1fea5 = pro1rel1spr1fea5;
	}

	/**
	 * @return the pro1rel1spr1fea5
	 */
	public Feature getPro1rel1spr1fea5() {
		return this.pro1rel1spr1fea5;
	}

	/**
	 * @param pro1rel1spr2fea1
	 *            the pro1rel1spr2fea1 to set
	 */
	public void setPro1rel1spr2fea1(final Feature pro1rel1spr2fea1) {
		this.pro1rel1spr2fea1 = pro1rel1spr2fea1;
	}

	/**
	 * @return the pro1rel1spr2fea1
	 */
	public Feature getPro1rel1spr2fea1() {
		return this.pro1rel1spr2fea1;
	}

	/**
	 * @param pro1rel1spr2fea2
	 *            the pro1rel1spr2fea2 to set
	 */
	public void setPro1rel1spr2fea2(final Feature pro1rel1spr2fea2) {
		this.pro1rel1spr2fea2 = pro1rel1spr2fea2;
	}

	/**
	 * @return the pro1rel1spr2fea2
	 */
	public Feature getPro1rel1spr2fea2() {
		return this.pro1rel1spr2fea2;
	}

	/**
	 * @param pro1rel1spr2fea3
	 *            the pro1rel1spr2fea3 to set
	 */
	public void setPro1rel1spr2fea3(final Feature pro1rel1spr2fea3) {
		this.pro1rel1spr2fea3 = pro1rel1spr2fea3;
	}

	/**
	 * @return the pro1rel1spr2fea3
	 */
	public Feature getPro1rel1spr2fea3() {
		return this.pro1rel1spr2fea3;
	}

	/**
	 * @param pro1rel1spr2fea4
	 *            the pro1rel1spr2fea4 to set
	 */
	public void setPro1rel1spr2fea4(final Feature pro1rel1spr2fea4) {
		this.pro1rel1spr2fea4 = pro1rel1spr2fea4;
	}

	/**
	 * @return the pro1rel1spr2fea4
	 */
	public Feature getPro1rel1spr2fea4() {
		return this.pro1rel1spr2fea4;
	}

	/**
	 * @param pro1rel1spr2fea5
	 *            the pro1rel1spr2fea5 to set
	 */
	public void setPro1rel1spr2fea5(final Feature pro1rel1spr2fea5) {
		this.pro1rel1spr2fea5 = pro1rel1spr2fea5;
	}

	/**
	 * @return the pro1rel1spr2fea5
	 */
	public Feature getPro1rel1spr2fea5() {
		return this.pro1rel1spr2fea5;
	}

	/**
	 * @param pro1rel1spr3fea1
	 *            the pro1rel1spr3fea1 to set
	 */
	public void setPro1rel1spr3fea1(final Feature pro1rel1spr3fea1) {
		this.pro1rel1spr3fea1 = pro1rel1spr3fea1;
	}

	/**
	 * @return the pro1rel1spr3fea1
	 */
	public Feature getPro1rel1spr3fea1() {
		return this.pro1rel1spr3fea1;
	}

	/**
	 * @param pro1rel1spr3fea2
	 *            the pro1rel1spr3fea2 to set
	 */
	public void setPro1rel1spr3fea2(final Feature pro1rel1spr3fea2) {
		this.pro1rel1spr3fea2 = pro1rel1spr3fea2;
	}

	/**
	 * @return the pro1rel1spr3fea2
	 */
	public Feature getPro1rel1spr3fea2() {
		return this.pro1rel1spr3fea2;
	}

	/**
	 * @param pro1rel1spr3fea3
	 *            the pro1rel1spr3fea3 to set
	 */
	public void setPro1rel1spr3fea3(final Feature pro1rel1spr3fea3) {
		this.pro1rel1spr3fea3 = pro1rel1spr3fea3;
	}

	/**
	 * @return the pro1rel1spr3fea3
	 */
	public Feature getPro1rel1spr3fea3() {
		return this.pro1rel1spr3fea3;
	}

	/**
	 * @param pro1rel1spr3fea4
	 *            the pro1rel1spr3fea4 to set
	 */
	public void setPro1rel1spr3fea4(final Feature pro1rel1spr3fea4) {
		this.pro1rel1spr3fea4 = pro1rel1spr3fea4;
	}

	/**
	 * @return the pro1rel1spr3fea4
	 */
	public Feature getPro1rel1spr3fea4() {
		return this.pro1rel1spr3fea4;
	}

	/**
	 * @param pro1rel1spr3fea5
	 *            the pro1rel1spr3fea5 to set
	 */
	public void setPro1rel1spr3fea5(final Feature pro1rel1spr3fea5) {
		this.pro1rel1spr3fea5 = pro1rel1spr3fea5;
	}

	/**
	 * @return the pro1rel1spr3fea5
	 */
	public Feature getPro1rel1spr3fea5() {
		return this.pro1rel1spr3fea5;
	}

	/**
	 * @param pro1rel1spr4fea1
	 *            the pro1rel1spr4fea1 to set
	 */
	public void setPro1rel1spr4fea1(final Feature pro1rel1spr4fea1) {
		this.pro1rel1spr4fea1 = pro1rel1spr4fea1;
	}

	/**
	 * @return the pro1rel1spr4fea1
	 */
	public Feature getPro1rel1spr4fea1() {
		return this.pro1rel1spr4fea1;
	}

	/**
	 * @param pro1rel1spr4fea2
	 *            the pro1rel1spr4fea2 to set
	 */
	public void setPro1rel1spr4fea2(final Feature pro1rel1spr4fea2) {
		this.pro1rel1spr4fea2 = pro1rel1spr4fea2;
	}

	/**
	 * @return the pro1rel1spr4fea2
	 */
	public Feature getPro1rel1spr4fea2() {
		return this.pro1rel1spr4fea2;
	}

	/**
	 * @param pro1rel1spr4fea3
	 *            the pro1rel1spr4fea3 to set
	 */
	public void setPro1rel1spr4fea3(final Feature pro1rel1spr4fea3) {
		this.pro1rel1spr4fea3 = pro1rel1spr4fea3;
	}

	/**
	 * @return the pro1rel1spr4fea3
	 */
	public Feature getPro1rel1spr4fea3() {
		return this.pro1rel1spr4fea3;
	}

	/**
	 * @param pro1rel1spr4fea4
	 *            the pro1rel1spr4fea4 to set
	 */
	public void setPro1rel1spr4fea4(final Feature pro1rel1spr4fea4) {
		this.pro1rel1spr4fea4 = pro1rel1spr4fea4;
	}

	/**
	 * @return the pro1rel1spr4fea4
	 */
	public Feature getPro1rel1spr4fea4() {
		return this.pro1rel1spr4fea4;
	}

	/**
	 * @param pro1rel1spr4fea5
	 *            the pro1rel1spr4fea5 to set
	 */
	public void setPro1rel1spr4fea5(final Feature pro1rel1spr4fea5) {
		this.pro1rel1spr4fea5 = pro1rel1spr4fea5;
	}

	/**
	 * @return the pro1rel1spr4fea5
	 */
	public Feature getPro1rel1spr4fea5() {
		return this.pro1rel1spr4fea5;
	}

	/**
	 * @param pro1rel1spr5fea1
	 *            the pro1rel1spr5fea1 to set
	 */
	public void setPro1rel1spr5fea1(final Feature pro1rel1spr5fea1) {
		this.pro1rel1spr5fea1 = pro1rel1spr5fea1;
	}

	/**
	 * @return the pro1rel1spr5fea1
	 */
	public Feature getPro1rel1spr5fea1() {
		return this.pro1rel1spr5fea1;
	}

	/**
	 * @param pro1rel1spr5fea2
	 *            the pro1rel1spr5fea2 to set
	 */
	public void setPro1rel1spr5fea2(final Feature pro1rel1spr5fea2) {
		this.pro1rel1spr5fea2 = pro1rel1spr5fea2;
	}

	/**
	 * @return the pro1rel1spr5fea2
	 */
	public Feature getPro1rel1spr5fea2() {
		return this.pro1rel1spr5fea2;
	}

	/**
	 * @param pro1rel1spr5fea3
	 *            the pro1rel1spr5fea3 to set
	 */
	public void setPro1rel1spr5fea3(final Feature pro1rel1spr5fea3) {
		this.pro1rel1spr5fea3 = pro1rel1spr5fea3;
	}

	/**
	 * @return the pro1rel1spr5fea3
	 */
	public Feature getPro1rel1spr5fea3() {
		return this.pro1rel1spr5fea3;
	}

	/**
	 * @param pro1rel1spr5fea4
	 *            the pro1rel1spr5fea4 to set
	 */
	public void setPro1rel1spr5fea4(final Feature pro1rel1spr5fea4) {
		this.pro1rel1spr5fea4 = pro1rel1spr5fea4;
	}

	/**
	 * @return the pro1rel1spr5fea4
	 */
	public Feature getPro1rel1spr5fea4() {
		return this.pro1rel1spr5fea4;
	}

	/**
	 * @param pro1rel2spr1fea2
	 *            the pro1rel2spr1fea2 to set
	 */
	public void setPro1rel2spr1fea2(final Feature pro1rel2spr1fea2) {
		this.pro1rel2spr1fea2 = pro1rel2spr1fea2;
	}

	/**
	 * @return the pro1rel2spr1fea2
	 */
	public Feature getPro1rel2spr1fea2() {
		return this.pro1rel2spr1fea2;
	}

	/**
	 * @param pro1rel2spr1fea3
	 *            the pro1rel2spr1fea3 to set
	 */
	public void setPro1rel2spr1fea3(final Feature pro1rel2spr1fea3) {
		this.pro1rel2spr1fea3 = pro1rel2spr1fea3;
	}

	/**
	 * @return the pro1rel2spr1fea3
	 */
	public Feature getPro1rel2spr1fea3() {
		return this.pro1rel2spr1fea3;
	}

	/**
	 * @param pro1rel2spr1fea4
	 *            the pro1rel2spr1fea4 to set
	 */
	public void setPro1rel2spr1fea4(final Feature pro1rel2spr1fea4) {
		this.pro1rel2spr1fea4 = pro1rel2spr1fea4;
	}

	/**
	 * @return the pro1rel2spr1fea4
	 */
	public Feature getPro1rel2spr1fea4() {
		return this.pro1rel2spr1fea4;
	}

	/**
	 * @param pro1rel2spr1fea5
	 *            the pro1rel2spr1fea5 to set
	 */
	public void setPro1rel2spr1fea5(final Feature pro1rel2spr1fea5) {
		this.pro1rel2spr1fea5 = pro1rel2spr1fea5;
	}

	/**
	 * @return the pro1rel2spr1fea5
	 */
	public Feature getPro1rel2spr1fea5() {
		return this.pro1rel2spr1fea5;
	}

	/**
	 * @param pro1rel2spr2fea1
	 *            the pro1rel2spr2fea1 to set
	 */
	public void setPro1rel2spr2fea1(final Feature pro1rel2spr2fea1) {
		this.pro1rel2spr2fea1 = pro1rel2spr2fea1;
	}

	/**
	 * @return the pro1rel2spr2fea1
	 */
	public Feature getPro1rel2spr2fea1() {
		return this.pro1rel2spr2fea1;
	}

	/**
	 * @param pro1rel2spr2fea2
	 *            the pro1rel2spr2fea2 to set
	 */
	public void setPro1rel2spr2fea2(final Feature pro1rel2spr2fea2) {
		this.pro1rel2spr2fea2 = pro1rel2spr2fea2;
	}

	/**
	 * @return the pro1rel2spr2fea2
	 */
	public Feature getPro1rel2spr2fea2() {
		return this.pro1rel2spr2fea2;
	}

	/**
	 * @param pro1rel2spr2fea3
	 *            the pro1rel2spr2fea3 to set
	 */
	public void setPro1rel2spr2fea3(final Feature pro1rel2spr2fea3) {
		this.pro1rel2spr2fea3 = pro1rel2spr2fea3;
	}

	/**
	 * @return the pro1rel2spr2fea3
	 */
	public Feature getPro1rel2spr2fea3() {
		return this.pro1rel2spr2fea3;
	}

	/**
	 * @param pro1rel2spr2fea4
	 *            the pro1rel2spr2fea4 to set
	 */
	public void setPro1rel2spr2fea4(final Feature pro1rel2spr2fea4) {
		this.pro1rel2spr2fea4 = pro1rel2spr2fea4;
	}

	/**
	 * @return the pro1rel2spr2fea4
	 */
	public Feature getPro1rel2spr2fea4() {
		return this.pro1rel2spr2fea4;
	}

	/**
	 * @param pro1rel2spr2fea5
	 *            the pro1rel2spr2fea5 to set
	 */
	public void setPro1rel2spr2fea5(final Feature pro1rel2spr2fea5) {
		this.pro1rel2spr2fea5 = pro1rel2spr2fea5;
	}

	/**
	 * @return the pro1rel2spr2fea5
	 */
	public Feature getPro1rel2spr2fea5() {
		return this.pro1rel2spr2fea5;
	}

	/**
	 * @param pro1rel2spr3fea1
	 *            the pro1rel2spr3fea1 to set
	 */
	public void setPro1rel2spr3fea1(final Feature pro1rel2spr3fea1) {
		this.pro1rel2spr3fea1 = pro1rel2spr3fea1;
	}

	/**
	 * @return the pro1rel2spr3fea1
	 */
	public Feature getPro1rel2spr3fea1() {
		return this.pro1rel2spr3fea1;
	}

	/**
	 * @param pro1rel2spr3fea2
	 *            the pro1rel2spr3fea2 to set
	 */
	public void setPro1rel2spr3fea2(final Feature pro1rel2spr3fea2) {
		this.pro1rel2spr3fea2 = pro1rel2spr3fea2;
	}

	/**
	 * @return the pro1rel2spr3fea2
	 */
	public Feature getPro1rel2spr3fea2() {
		return this.pro1rel2spr3fea2;
	}

	/**
	 * @param pro1rel2spr3fea3
	 *            the pro1rel2spr3fea3 to set
	 */
	public void setPro1rel2spr3fea3(final Feature pro1rel2spr3fea3) {
		this.pro1rel2spr3fea3 = pro1rel2spr3fea3;
	}

	/**
	 * @return the pro1rel2spr3fea3
	 */
	public Feature getPro1rel2spr3fea3() {
		return this.pro1rel2spr3fea3;
	}

	/**
	 * @param pro1rel2spr3fea4
	 *            the pro1rel2spr3fea4 to set
	 */
	public void setPro1rel2spr3fea4(final Feature pro1rel2spr3fea4) {
		this.pro1rel2spr3fea4 = pro1rel2spr3fea4;
	}

	/**
	 * @return the pro1rel2spr3fea4
	 */
	public Feature getPro1rel2spr3fea4() {
		return this.pro1rel2spr3fea4;
	}

	/**
	 * @param pro1rel2spr3fea5
	 *            the pro1rel2spr3fea5 to set
	 */
	public void setPro1rel2spr3fea5(final Feature pro1rel2spr3fea5) {
		this.pro1rel2spr3fea5 = pro1rel2spr3fea5;
	}

	/**
	 * @return the pro1rel2spr3fea5
	 */
	public Feature getPro1rel2spr3fea5() {
		return this.pro1rel2spr3fea5;
	}

	/**
	 * @param pro1rel2spr4fea1
	 *            the pro1rel2spr4fea1 to set
	 */
	public void setPro1rel2spr4fea1(final Feature pro1rel2spr4fea1) {
		this.pro1rel2spr4fea1 = pro1rel2spr4fea1;
	}

	/**
	 * @return the pro1rel2spr4fea1
	 */
	public Feature getPro1rel2spr4fea1() {
		return this.pro1rel2spr4fea1;
	}

	/**
	 * @param pro1rel2spr4fea2
	 *            the pro1rel2spr4fea2 to set
	 */
	public void setPro1rel2spr4fea2(final Feature pro1rel2spr4fea2) {
		this.pro1rel2spr4fea2 = pro1rel2spr4fea2;
	}

	/**
	 * @return the pro1rel2spr4fea2
	 */
	public Feature getPro1rel2spr4fea2() {
		return this.pro1rel2spr4fea2;
	}

	/**
	 * @param pro1rel2spr4fea3
	 *            the pro1rel2spr4fea3 to set
	 */
	public void setPro1rel2spr4fea3(final Feature pro1rel2spr4fea3) {
		this.pro1rel2spr4fea3 = pro1rel2spr4fea3;
	}

	/**
	 * @return the pro1rel2spr4fea3
	 */
	public Feature getPro1rel2spr4fea3() {
		return this.pro1rel2spr4fea3;
	}

	/**
	 * @param pro1rel2spr4fea4
	 *            the pro1rel2spr4fea4 to set
	 */
	public void setPro1rel2spr4fea4(final Feature pro1rel2spr4fea4) {
		this.pro1rel2spr4fea4 = pro1rel2spr4fea4;
	}

	/**
	 * @return the pro1rel2spr4fea4
	 */
	public Feature getPro1rel2spr4fea4() {
		return this.pro1rel2spr4fea4;
	}

	/**
	 * @param pro1rel2spr4fea5
	 *            the pro1rel2spr4fea5 to set
	 */
	public void setPro1rel2spr4fea5(final Feature pro1rel2spr4fea5) {
		this.pro1rel2spr4fea5 = pro1rel2spr4fea5;
	}

	/**
	 * @return the pro1rel2spr4fea5
	 */
	public Feature getPro1rel2spr4fea5() {
		return this.pro1rel2spr4fea5;
	}

	/**
	 * @param pro1rel2spr5fea1
	 *            the pro1rel2spr5fea1 to set
	 */
	public void setPro1rel2spr5fea1(final Feature pro1rel2spr5fea1) {
		this.pro1rel2spr5fea1 = pro1rel2spr5fea1;
	}

	/**
	 * @return the pro1rel2spr5fea1
	 */
	public Feature getPro1rel2spr5fea1() {
		return this.pro1rel2spr5fea1;
	}

	/**
	 * @param pro1rel2spr5fea2
	 *            the pro1rel2spr5fea2 to set
	 */
	public void setPro1rel2spr5fea2(final Feature pro1rel2spr5fea2) {
		this.pro1rel2spr5fea2 = pro1rel2spr5fea2;
	}

	/**
	 * @return the pro1rel2spr5fea2
	 */
	public Feature getPro1rel2spr5fea2() {
		return this.pro1rel2spr5fea2;
	}

	/**
	 * @param pro1rel2spr5fea3
	 *            the pro1rel2spr5fea3 to set
	 */
	public void setPro1rel2spr5fea3(final Feature pro1rel2spr5fea3) {
		this.pro1rel2spr5fea3 = pro1rel2spr5fea3;
	}

	/**
	 * @return the pro1rel2spr5fea3
	 */
	public Feature getPro1rel2spr5fea3() {
		return this.pro1rel2spr5fea3;
	}

	/**
	 * @param pro1rel2spr5fea4
	 *            the pro1rel2spr5fea4 to set
	 */
	public void setPro1rel2spr5fea4(final Feature pro1rel2spr5fea4) {
		this.pro1rel2spr5fea4 = pro1rel2spr5fea4;
	}

	/**
	 * @return the pro1rel2spr5fea4
	 */
	public Feature getPro1rel2spr5fea4() {
		return this.pro1rel2spr5fea4;
	}

	/**
	 * @param pro1rel2spr5fea5
	 *            the pro1rel2spr5fea5 to set
	 */
	public void setPro1rel2spr5fea5(final Feature pro1rel2spr5fea5) {
		this.pro1rel2spr5fea5 = pro1rel2spr5fea5;
	}

	/**
	 * @return the pro1rel2spr5fea5
	 */
	public Feature getPro1rel2spr5fea5() {
		return this.pro1rel2spr5fea5;
	}

	/**
	 * @param pro2rel1spr1fea1
	 *            the pro2rel1spr1fea1 to set
	 */
	public void setPro2rel1spr1fea1(final Feature pro2rel1spr1fea1) {
		this.pro2rel1spr1fea1 = pro2rel1spr1fea1;
	}

	/**
	 * @return the pro2rel1spr1fea1
	 */
	public Feature getPro2rel1spr1fea1() {
		return this.pro2rel1spr1fea1;
	}

	/**
	 * @param pro2rel1spr1fea2
	 *            the pro2rel1spr1fea2 to set
	 */
	public void setPro2rel1spr1fea2(final Feature pro2rel1spr1fea2) {
		this.pro2rel1spr1fea2 = pro2rel1spr1fea2;
	}

	/**
	 * @return the pro2rel1spr1fea2
	 */
	public Feature getPro2rel1spr1fea2() {
		return this.pro2rel1spr1fea2;
	}

	/**
	 * @param pro2rel1spr1fea3
	 *            the pro2rel1spr1fea3 to set
	 */
	public void setPro2rel1spr1fea3(final Feature pro2rel1spr1fea3) {
		this.pro2rel1spr1fea3 = pro2rel1spr1fea3;
	}

	/**
	 * @return the pro2rel1spr1fea3
	 */
	public Feature getPro2rel1spr1fea3() {
		return this.pro2rel1spr1fea3;
	}

	/**
	 * @param pro2rel1spr1fea4
	 *            the pro2rel1spr1fea4 to set
	 */
	public void setPro2rel1spr1fea4(final Feature pro2rel1spr1fea4) {
		this.pro2rel1spr1fea4 = pro2rel1spr1fea4;
	}

	/**
	 * @return the pro2rel1spr1fea4
	 */
	public Feature getPro2rel1spr1fea4() {
		return this.pro2rel1spr1fea4;
	}

	/**
	 * @param pro2rel1spr1fea5
	 *            the pro2rel1spr1fea5 to set
	 */
	public void setPro2rel1spr1fea5(final Feature pro2rel1spr1fea5) {
		this.pro2rel1spr1fea5 = pro2rel1spr1fea5;
	}

	/**
	 * @return the pro2rel1spr1fea5
	 */
	public Feature getPro2rel1spr1fea5() {
		return this.pro2rel1spr1fea5;
	}

	/**
	 * @param pro2rel1spr2fea1
	 *            the pro2rel1spr2fea1 to set
	 */
	public void setPro2rel1spr2fea1(final Feature pro2rel1spr2fea1) {
		this.pro2rel1spr2fea1 = pro2rel1spr2fea1;
	}

	/**
	 * @return the pro2rel1spr2fea1
	 */
	public Feature getPro2rel1spr2fea1() {
		return this.pro2rel1spr2fea1;
	}

	/**
	 * @param pro2rel1spr2fea2
	 *            the pro2rel1spr2fea2 to set
	 */
	public void setPro2rel1spr2fea2(final Feature pro2rel1spr2fea2) {
		this.pro2rel1spr2fea2 = pro2rel1spr2fea2;
	}

	/**
	 * @return the pro2rel1spr2fea2
	 */
	public Feature getPro2rel1spr2fea2() {
		return this.pro2rel1spr2fea2;
	}

	/**
	 * @param pro2rel1spr2fea3
	 *            the pro2rel1spr2fea3 to set
	 */
	public void setPro2rel1spr2fea3(final Feature pro2rel1spr2fea3) {
		this.pro2rel1spr2fea3 = pro2rel1spr2fea3;
	}

	/**
	 * @return the pro2rel1spr2fea3
	 */
	public Feature getPro2rel1spr2fea3() {
		return this.pro2rel1spr2fea3;
	}

	/**
	 * @param pro2rel1spr2fea4
	 *            the pro2rel1spr2fea4 to set
	 */
	public void setPro2rel1spr2fea4(final Feature pro2rel1spr2fea4) {
		this.pro2rel1spr2fea4 = pro2rel1spr2fea4;
	}

	/**
	 * @return the pro2rel1spr2fea4
	 */
	public Feature getPro2rel1spr2fea4() {
		return this.pro2rel1spr2fea4;
	}

	/**
	 * @param pro2rel1spr2fea5
	 *            the pro2rel1spr2fea5 to set
	 */
	public void setPro2rel1spr2fea5(final Feature pro2rel1spr2fea5) {
		this.pro2rel1spr2fea5 = pro2rel1spr2fea5;
	}

	/**
	 * @return the pro2rel1spr2fea5
	 */
	public Feature getPro2rel1spr2fea5() {
		return this.pro2rel1spr2fea5;
	}

	/**
	 * @param pro2rel1spr3fea1
	 *            the pro2rel1spr3fea1 to set
	 */
	public void setPro2rel1spr3fea1(final Feature pro2rel1spr3fea1) {
		this.pro2rel1spr3fea1 = pro2rel1spr3fea1;
	}

	/**
	 * @return the pro2rel1spr3fea1
	 */
	public Feature getPro2rel1spr3fea1() {
		return this.pro2rel1spr3fea1;
	}

	/**
	 * @param pro2rel1spr3fea2
	 *            the pro2rel1spr3fea2 to set
	 */
	public void setPro2rel1spr3fea2(final Feature pro2rel1spr3fea2) {
		this.pro2rel1spr3fea2 = pro2rel1spr3fea2;
	}

	/**
	 * @return the pro2rel1spr3fea2
	 */
	public Feature getPro2rel1spr3fea2() {
		return this.pro2rel1spr3fea2;
	}

	/**
	 * @param pro2rel1spr3fea3
	 *            the pro2rel1spr3fea3 to set
	 */
	public void setPro2rel1spr3fea3(final Feature pro2rel1spr3fea3) {
		this.pro2rel1spr3fea3 = pro2rel1spr3fea3;
	}

	/**
	 * @return the pro2rel1spr3fea3
	 */
	public Feature getPro2rel1spr3fea3() {
		return this.pro2rel1spr3fea3;
	}

	/**
	 * @param pro2rel1spr3fea4
	 *            the pro2rel1spr3fea4 to set
	 */
	public void setPro2rel1spr3fea4(final Feature pro2rel1spr3fea4) {
		this.pro2rel1spr3fea4 = pro2rel1spr3fea4;
	}

	/**
	 * @return the pro2rel1spr3fea4
	 */
	public Feature getPro2rel1spr3fea4() {
		return this.pro2rel1spr3fea4;
	}

	/**
	 * @param pro2rel1spr3fea5
	 *            the pro2rel1spr3fea5 to set
	 */
	public void setPro2rel1spr3fea5(final Feature pro2rel1spr3fea5) {
		this.pro2rel1spr3fea5 = pro2rel1spr3fea5;
	}

	/**
	 * @return the pro2rel1spr3fea5
	 */
	public Feature getPro2rel1spr3fea5() {
		return this.pro2rel1spr3fea5;
	}

	/**
	 * @param pro2rel1spr4fea1
	 *            the pro2rel1spr4fea1 to set
	 */
	public void setPro2rel1spr4fea1(final Feature pro2rel1spr4fea1) {
		this.pro2rel1spr4fea1 = pro2rel1spr4fea1;
	}

	/**
	 * @return the pro2rel1spr4fea1
	 */
	public Feature getPro2rel1spr4fea1() {
		return this.pro2rel1spr4fea1;
	}

	/**
	 * @param pro2rel1spr4fea2
	 *            the pro2rel1spr4fea2 to set
	 */
	public void setPro2rel1spr4fea2(final Feature pro2rel1spr4fea2) {
		this.pro2rel1spr4fea2 = pro2rel1spr4fea2;
	}

	/**
	 * @return the pro2rel1spr4fea2
	 */
	public Feature getPro2rel1spr4fea2() {
		return this.pro2rel1spr4fea2;
	}

	/**
	 * @param pro2rel1spr4fea3
	 *            the pro2rel1spr4fea3 to set
	 */
	public void setPro2rel1spr4fea3(final Feature pro2rel1spr4fea3) {
		this.pro2rel1spr4fea3 = pro2rel1spr4fea3;
	}

	/**
	 * @return the pro2rel1spr4fea3
	 */
	public Feature getPro2rel1spr4fea3() {
		return this.pro2rel1spr4fea3;
	}

	/**
	 * @param pro2rel1spr4fea4
	 *            the pro2rel1spr4fea4 to set
	 */
	public void setPro2rel1spr4fea4(final Feature pro2rel1spr4fea4) {
		this.pro2rel1spr4fea4 = pro2rel1spr4fea4;
	}

	/**
	 * @return the pro2rel1spr4fea4
	 */
	public Feature getPro2rel1spr4fea4() {
		return this.pro2rel1spr4fea4;
	}

	/**
	 * @param pro2rel1spr4fea5
	 *            the pro2rel1spr4fea5 to set
	 */
	public void setPro2rel1spr4fea5(final Feature pro2rel1spr4fea5) {
		this.pro2rel1spr4fea5 = pro2rel1spr4fea5;
	}

	/**
	 * @return the pro2rel1spr4fea5
	 */
	public Feature getPro2rel1spr4fea5() {
		return this.pro2rel1spr4fea5;
	}

	/**
	 * @param pro2rel1spr5fea1
	 *            the pro2rel1spr5fea1 to set
	 */
	public void setPro2rel1spr5fea1(final Feature pro2rel1spr5fea1) {
		this.pro2rel1spr5fea1 = pro2rel1spr5fea1;
	}

	/**
	 * @return the pro2rel1spr5fea1
	 */
	public Feature getPro2rel1spr5fea1() {
		return this.pro2rel1spr5fea1;
	}

	/**
	 * @param pro2rel1spr5fea2
	 *            the pro2rel1spr5fea2 to set
	 */
	public void setPro2rel1spr5fea2(final Feature pro2rel1spr5fea2) {
		this.pro2rel1spr5fea2 = pro2rel1spr5fea2;
	}

	/**
	 * @return the pro2rel1spr5fea2
	 */
	public Feature getPro2rel1spr5fea2() {
		return this.pro2rel1spr5fea2;
	}

	/**
	 * @param pro2rel1spr5fea3
	 *            the pro2rel1spr5fea3 to set
	 */
	public void setPro2rel1spr5fea3(final Feature pro2rel1spr5fea3) {
		this.pro2rel1spr5fea3 = pro2rel1spr5fea3;
	}

	/**
	 * @return the pro2rel1spr5fea3
	 */
	public Feature getPro2rel1spr5fea3() {
		return this.pro2rel1spr5fea3;
	}

	/**
	 * @param pro2rel1spr5fea4
	 *            the pro2rel1spr5fea4 to set
	 */
	public void setPro2rel1spr5fea4(final Feature pro2rel1spr5fea4) {
		this.pro2rel1spr5fea4 = pro2rel1spr5fea4;
	}

	/**
	 * @return the pro2rel1spr5fea4
	 */
	public Feature getPro2rel1spr5fea4() {
		return this.pro2rel1spr5fea4;
	}

	/**
	 * @param pro2rel1spr5fea5
	 *            the pro2rel1spr5fea5 to set
	 */
	public void setPro2rel1spr5fea5(final Feature pro2rel1spr5fea5) {
		this.pro2rel1spr5fea5 = pro2rel1spr5fea5;
	}

	/**
	 * @return the pro2rel1spr5fea5
	 */
	public Feature getPro2rel1spr5fea5() {
		return this.pro2rel1spr5fea5;
	}

	/**
	 * @param pro2rel2spr1fea1
	 *            the pro2rel2spr1fea1 to set
	 */
	public void setPro2rel2spr1fea1(final Feature pro2rel2spr1fea1) {
		this.pro2rel2spr1fea1 = pro2rel2spr1fea1;
	}

	/**
	 * @return the pro2rel2spr1fea1
	 */
	public Feature getPro2rel2spr1fea1() {
		return this.pro2rel2spr1fea1;
	}

	/**
	 * @param pro2rel2spr1fea2
	 *            the pro2rel2spr1fea2 to set
	 */
	public void setPro2rel2spr1fea2(final Feature pro2rel2spr1fea2) {
		this.pro2rel2spr1fea2 = pro2rel2spr1fea2;
	}

	/**
	 * @return the pro2rel2spr1fea2
	 */
	public Feature getPro2rel2spr1fea2() {
		return this.pro2rel2spr1fea2;
	}

	/**
	 * @param pro2rel2spr1fea3
	 *            the pro2rel2spr1fea3 to set
	 */
	public void setPro2rel2spr1fea3(final Feature pro2rel2spr1fea3) {
		this.pro2rel2spr1fea3 = pro2rel2spr1fea3;
	}

	/**
	 * @return the pro2rel2spr1fea3
	 */
	public Feature getPro2rel2spr1fea3() {
		return this.pro2rel2spr1fea3;
	}

	/**
	 * @param pro2rel2spr1fea4
	 *            the pro2rel2spr1fea4 to set
	 */
	public void setPro2rel2spr1fea4(final Feature pro2rel2spr1fea4) {
		this.pro2rel2spr1fea4 = pro2rel2spr1fea4;
	}

	/**
	 * @return the pro2rel2spr1fea4
	 */
	public Feature getPro2rel2spr1fea4() {
		return this.pro2rel2spr1fea4;
	}

	/**
	 * @param pro2rel2spr1fea5
	 *            the pro2rel2spr1fea5 to set
	 */
	public void setPro2rel2spr1fea5(final Feature pro2rel2spr1fea5) {
		this.pro2rel2spr1fea5 = pro2rel2spr1fea5;
	}

	/**
	 * @return the pro2rel2spr1fea5
	 */
	public Feature getPro2rel2spr1fea5() {
		return this.pro2rel2spr1fea5;
	}

	/**
	 * @param pro2rel2spr2fea1
	 *            the pro2rel2spr2fea1 to set
	 */
	public void setPro2rel2spr2fea1(final Feature pro2rel2spr2fea1) {
		this.pro2rel2spr2fea1 = pro2rel2spr2fea1;
	}

	/**
	 * @return the pro2rel2spr2fea1
	 */
	public Feature getPro2rel2spr2fea1() {
		return this.pro2rel2spr2fea1;
	}

	/**
	 * @param pro2rel2spr2fea2
	 *            the pro2rel2spr2fea2 to set
	 */
	public void setPro2rel2spr2fea2(final Feature pro2rel2spr2fea2) {
		this.pro2rel2spr2fea2 = pro2rel2spr2fea2;
	}

	/**
	 * @return the pro2rel2spr2fea2
	 */
	public Feature getPro2rel2spr2fea2() {
		return this.pro2rel2spr2fea2;
	}

	/**
	 * @param pro2rel2spr2fea3
	 *            the pro2rel2spr2fea3 to set
	 */
	public void setPro2rel2spr2fea3(final Feature pro2rel2spr2fea3) {
		this.pro2rel2spr2fea3 = pro2rel2spr2fea3;
	}

	/**
	 * @return the pro2rel2spr2fea3
	 */
	public Feature getPro2rel2spr2fea3() {
		return this.pro2rel2spr2fea3;
	}

	/**
	 * @param pro2rel2spr2fea4
	 *            the pro2rel2spr2fea4 to set
	 */
	public void setPro2rel2spr2fea4(final Feature pro2rel2spr2fea4) {
		this.pro2rel2spr2fea4 = pro2rel2spr2fea4;
	}

	/**
	 * @return the pro2rel2spr2fea4
	 */
	public Feature getPro2rel2spr2fea4() {
		return this.pro2rel2spr2fea4;
	}

	/**
	 * @param pro2rel2spr2fea5
	 *            the pro2rel2spr2fea5 to set
	 */
	public void setPro2rel2spr2fea5(final Feature pro2rel2spr2fea5) {
		this.pro2rel2spr2fea5 = pro2rel2spr2fea5;
	}

	/**
	 * @return the pro2rel2spr2fea5
	 */
	public Feature getPro2rel2spr2fea5() {
		return this.pro2rel2spr2fea5;
	}

	/**
	 * @param pro2rel2spr3fea1
	 *            the pro2rel2spr3fea1 to set
	 */
	public void setPro2rel2spr3fea1(final Feature pro2rel2spr3fea1) {
		this.pro2rel2spr3fea1 = pro2rel2spr3fea1;
	}

	/**
	 * @return the pro2rel2spr3fea1
	 */
	public Feature getPro2rel2spr3fea1() {
		return this.pro2rel2spr3fea1;
	}

	/**
	 * @param pro2rel2spr3fea2
	 *            the pro2rel2spr3fea2 to set
	 */
	public void setPro2rel2spr3fea2(final Feature pro2rel2spr3fea2) {
		this.pro2rel2spr3fea2 = pro2rel2spr3fea2;
	}

	/**
	 * @return the pro2rel2spr3fea2
	 */
	public Feature getPro2rel2spr3fea2() {
		return this.pro2rel2spr3fea2;
	}

	/**
	 * @param pro2rel2spr3fea3
	 *            the pro2rel2spr3fea3 to set
	 */
	public void setPro2rel2spr3fea3(final Feature pro2rel2spr3fea3) {
		this.pro2rel2spr3fea3 = pro2rel2spr3fea3;
	}

	/**
	 * @return the pro2rel2spr3fea3
	 */
	public Feature getPro2rel2spr3fea3() {
		return this.pro2rel2spr3fea3;
	}

	/**
	 * @param pro2rel2spr3fea4
	 *            the pro2rel2spr3fea4 to set
	 */
	public void setPro2rel2spr3fea4(final Feature pro2rel2spr3fea4) {
		this.pro2rel2spr3fea4 = pro2rel2spr3fea4;
	}

	/**
	 * @return the pro2rel2spr3fea4
	 */
	public Feature getPro2rel2spr3fea4() {
		return this.pro2rel2spr3fea4;
	}

	/**
	 * @param pro2rel2spr3fea5
	 *            the pro2rel2spr3fea5 to set
	 */
	public void setPro2rel2spr3fea5(final Feature pro2rel2spr3fea5) {
		this.pro2rel2spr3fea5 = pro2rel2spr3fea5;
	}

	/**
	 * @return the pro2rel2spr3fea5
	 */
	public Feature getPro2rel2spr3fea5() {
		return this.pro2rel2spr3fea5;
	}

	/**
	 * @param pro2rel2spr4fea1
	 *            the pro2rel2spr4fea1 to set
	 */
	public void setPro2rel2spr4fea1(final Feature pro2rel2spr4fea1) {
		this.pro2rel2spr4fea1 = pro2rel2spr4fea1;
	}

	/**
	 * @return the pro2rel2spr4fea1
	 */
	public Feature getPro2rel2spr4fea1() {
		return this.pro2rel2spr4fea1;
	}

	/**
	 * @param pro2rel2spr4fea2
	 *            the pro2rel2spr4fea2 to set
	 */
	public void setPro2rel2spr4fea2(final Feature pro2rel2spr4fea2) {
		this.pro2rel2spr4fea2 = pro2rel2spr4fea2;
	}

	/**
	 * @return the pro2rel2spr4fea2
	 */
	public Feature getPro2rel2spr4fea2() {
		return this.pro2rel2spr4fea2;
	}

	/**
	 * @param pro2rel2spr4fea3
	 *            the pro2rel2spr4fea3 to set
	 */
	public void setPro2rel2spr4fea3(final Feature pro2rel2spr4fea3) {
		this.pro2rel2spr4fea3 = pro2rel2spr4fea3;
	}

	/**
	 * @return the pro2rel2spr4fea3
	 */
	public Feature getPro2rel2spr4fea3() {
		return this.pro2rel2spr4fea3;
	}

	/**
	 * @param pro2rel2spr4fea4
	 *            the pro2rel2spr4fea4 to set
	 */
	public void setPro2rel2spr4fea4(final Feature pro2rel2spr4fea4) {
		this.pro2rel2spr4fea4 = pro2rel2spr4fea4;
	}

	/**
	 * @return the pro2rel2spr4fea4
	 */
	public Feature getPro2rel2spr4fea4() {
		return this.pro2rel2spr4fea4;
	}

	/**
	 * @param pro2rel2spr4fea5
	 *            the pro2rel2spr4fea5 to set
	 */
	public void setPro2rel2spr4fea5(final Feature pro2rel2spr4fea5) {
		this.pro2rel2spr4fea5 = pro2rel2spr4fea5;
	}

	/**
	 * @return the pro2rel2spr4fea5
	 */
	public Feature getPro2rel2spr4fea5() {
		return this.pro2rel2spr4fea5;
	}

	/**
	 * @param pro2rel2spr5fea1
	 *            the pro2rel2spr5fea1 to set
	 */
	public void setPro2rel2spr5fea1(final Feature pro2rel2spr5fea1) {
		this.pro2rel2spr5fea1 = pro2rel2spr5fea1;
	}

	/**
	 * @return the pro2rel2spr5fea1
	 */
	public Feature getPro2rel2spr5fea1() {
		return this.pro2rel2spr5fea1;
	}

	/**
	 * @param pro2rel2spr5fea2
	 *            the pro2rel2spr5fea2 to set
	 */
	public void setPro2rel2spr5fea2(final Feature pro2rel2spr5fea2) {
		this.pro2rel2spr5fea2 = pro2rel2spr5fea2;
	}

	/**
	 * @return the pro2rel2spr5fea2
	 */
	public Feature getPro2rel2spr5fea2() {
		return this.pro2rel2spr5fea2;
	}

	/**
	 * @param pro2rel2spr5fea3
	 *            the pro2rel2spr5fea3 to set
	 */
	public void setPro2rel2spr5fea3(final Feature pro2rel2spr5fea3) {
		this.pro2rel2spr5fea3 = pro2rel2spr5fea3;
	}

	/**
	 * @return the pro2rel2spr5fea3
	 */
	public Feature getPro2rel2spr5fea3() {
		return this.pro2rel2spr5fea3;
	}

	/**
	 * @param pro2rel2spr5fea4
	 *            the pro2rel2spr5fea4 to set
	 */
	public void setPro2rel2spr5fea4(final Feature pro2rel2spr5fea4) {
		this.pro2rel2spr5fea4 = pro2rel2spr5fea4;
	}

	/**
	 * @return the pro2rel2spr5fea4
	 */
	public Feature getPro2rel2spr5fea4() {
		return this.pro2rel2spr5fea4;
	}

	/**
	 * @param pro2rel2spr5fea5
	 *            the pro2rel2spr5fea5 to set
	 */
	public void setPro2rel2spr5fea5(final Feature pro2rel2spr5fea5) {
		this.pro2rel2spr5fea5 = pro2rel2spr5fea5;
	}

	/**
	 * @return the pro2rel2spr5fea5
	 */
	public Feature getPro2rel2spr5fea5() {
		return this.pro2rel2spr5fea5;
	}

	/**
	 * @param roleTSUser
	 *            the roleTSUser to set
	 */
	public void setRoleTSUser(final Role roleTSUser) {
		this.roleTSUser = roleTSUser;
	}

	/**
	 * @return the roleTSUser
	 */
	public Role getRoleTSUser() {
		return this.roleTSUser;
	}

	/**
	 * @param roleScrummaster
	 *            the roleScrummaster to set
	 */
	public void setRoleScrummaster(final Role roleScrummaster) {
		this.roleScrummaster = roleScrummaster;
	}

	/**
	 * @return the roleScrummaster
	 */
	public Role getRoleScrummaster() {
		return this.roleScrummaster;
	}

	/**
	 * @param roleProductOwner
	 *            the roleProductOwner to set
	 */
	public void setRoleProductOwner(final Role roleProductOwner) {
		this.roleProductOwner = roleProductOwner;
	}

	/**
	 * @return the roleProductOwner
	 */
	public Role getRoleProductOwner() {
		return this.roleProductOwner;
	}

	/**
	 * @param roleDeveloper
	 *            the roleDeveloper to set
	 */
	public void setRoleDeveloper(final Role roleDeveloper) {
		this.roleDeveloper = roleDeveloper;
	}

	/**
	 * @return the roleDeveloper
	 */
	public Role getRoleDeveloper() {
		return this.roleDeveloper;
	}

	/**
	 * @param roleTester
	 *            the roleTester to set
	 */
	public void setRoleTester(final Role roleTester) {
		this.roleTester = roleTester;
	}

	/**
	 * @return the roleTester
	 */
	public Role getRoleTester() {
		return this.roleTester;
	}

	/**
	 * @param roleGUIWiz
	 *            the roleGUIWiz to set
	 */
	public void setRoleGUIWiz(final Role roleGUIWiz) {
		this.roleGUIWiz = roleGUIWiz;
	}

	/**
	 * @return the roleGUIWiz
	 */
	public Role getRoleGUIWiz() {
		return this.roleGUIWiz;
	}

	/**
	 * @param pSarahToSet
	 *            the pSarah to set
	 */
	public void setpSarah(final Person pSarahToSet) {
		this.pSarah = pSarahToSet;
	}

	/**
	 * @return the pSarah
	 */
	public Person getpSarah() {
		return this.pSarah;
	}

	/**
	 * @param pWilkenToSet
	 *            the pWilken to set
	 */
	public void setpWilken(final Person pWilkenToSet) {
		this.pWilken = pWilkenToSet;
	}

	/**
	 * @return the pWilken
	 */
	public Person getpWilken() {
		return this.pWilken;
	}

	/**
	 * @param pChristinToSet
	 *            the pChristin to set
	 */
	public void setpChristin(final Person pChristinToSet) {
		this.pChristin = pChristinToSet;
	}

	/**
	 * @return the pChristin
	 */
	public Person getpChristin() {
		return this.pChristin;
	}

	/**
	 * @param pBjoernToSet
	 *            the pBjoern to set
	 */
	protected void setpBjoern(final Person pBjoernToSet) {
		this.pBjoern = pBjoernToSet;
	}

	/**
	 * @return the pBjoern
	 */
	protected Person getpBjoern() {
		return this.pBjoern;
	}

	/**
	 * @param pChrisToSet
	 *            the pChris to set
	 */
	public void setpChris(final Person pChrisToSet) {
		this.pChris = pChrisToSet;
	}

	/**
	 * @return the pChris
	 */
	public Person getpChris() {
		return this.pChris;
	}

	/**
	 * @param team1
	 *            the team1 to set
	 */
	public void setTeam1(final Team team1) {
		this.team1 = team1;
	}

	/**
	 * @return the team1
	 */
	public Team getTeam1() {
		return this.team1;
	}

	/**
	 * @param team2
	 *            the team2 to set
	 */
	public void setTeam2(final Team team2) {
		this.team2 = team2;
	}

	/**
	 * @return the team2
	 */
	public Team getTeam2() {
		return this.team2;
	}

	/**
	 * @param team3
	 *            the team3 to set
	 */
	protected void setTeam3(final Team team3) {
		this.team3 = team3;
	}

	/**
	 * @return the team3
	 */
	protected Team getTeam3() {
		return this.team3;
	}

	/**
	 * @param team4
	 *            the team4 to set
	 */
	public void setTeam4(final Team team4) {
		this.team4 = team4;
	}

	/**
	 * @return the team4
	 */
	public Team getTeam4() {
		return this.team4;
	}

	/**
	 * @param projekt1
	 *            the projekt1 to set
	 */
	public void setProjekt1(final Project projekt1) {
		this.projekt1 = projekt1;
	}

	/**
	 * @return the projekt1
	 */
	public Project getProjekt1() {
		return this.projekt1;
	}

	/**
	 * @param projekt2
	 *            the projekt2 to set
	 */
	public void setProjekt2(final Project projekt2) {
		this.projekt2 = projekt2;
	}

	/**
	 * @return the projekt2
	 */
	public Project getProjekt2() {
		return this.projekt2;
	}

	/**
	 * @param pro1rel1
	 *            the pro1rel1 to set
	 */
	public void setPro1rel1(final Release pro1rel1) {
		this.pro1rel1 = pro1rel1;
	}

	/**
	 * @return the pro1rel1
	 */
	public Release getPro1rel1() {
		return this.pro1rel1;
	}

	/**
	 * @param pro1rel2
	 *            the pro1rel2 to set
	 */
	public void setPro1rel2(final Release pro1rel2) {
		this.pro1rel2 = pro1rel2;
	}

	/**
	 * @return the pro1rel2
	 */
	public Release getPro1rel2() {
		return this.pro1rel2;
	}

	/**
	 * @param pro2rel1
	 *            the pro2rel1 to set
	 */
	public void setPro2rel1(final Release pro2rel1) {
		this.pro2rel1 = pro2rel1;
	}

	/**
	 * @return the pro2rel1
	 */
	public Release getPro2rel1() {
		return this.pro2rel1;
	}

	/**
	 * @param pro2rel2
	 *            the pro2rel2 to set
	 */
	public void setPro2rel2(final Release pro2rel2) {
		this.pro2rel2 = pro2rel2;
	}

	/**
	 * @return the pro2rel2
	 */
	public Release getPro2rel2() {
		return this.pro2rel2;
	}

	/**
	 * @param pro1rel1spr1
	 *            the pro1rel1spr1 to set
	 */
	public void setPro1rel1spr1(final Sprint pro1rel1spr1) {
		this.pro1rel1spr1 = pro1rel1spr1;
	}

	/**
	 * @return the pro1rel1spr1
	 */
	public Sprint getPro1rel1spr1() {
		return this.pro1rel1spr1;
	}

	/**
	 * @param pro1rel1spr2
	 *            the pro1rel1spr2 to set
	 */
	public void setPro1rel1spr2(final Sprint pro1rel1spr2) {
		this.pro1rel1spr2 = pro1rel1spr2;
	}

	/**
	 * @return the pro1rel1spr2
	 */
	public Sprint getPro1rel1spr2() {
		return this.pro1rel1spr2;
	}

	/**
	 * @param pro1rel1spr3
	 *            the pro1rel1spr3 to set
	 */
	public void setPro1rel1spr3(final Sprint pro1rel1spr3) {
		this.pro1rel1spr3 = pro1rel1spr3;
	}

	/**
	 * @return the pro1rel1spr3
	 */
	public Sprint getPro1rel1spr3() {
		return this.pro1rel1spr3;
	}

	/**
	 * @param pro1rel1spr4
	 *            the pro1rel1spr4 to set
	 */
	public void setPro1rel1spr4(final Sprint pro1rel1spr4) {
		this.pro1rel1spr4 = pro1rel1spr4;
	}

	/**
	 * @return the pro1rel1spr4
	 */
	public Sprint getPro1rel1spr4() {
		return this.pro1rel1spr4;
	}

	/**
	 * @param pro1rel1spr5
	 *            the pro1rel1spr5 to set
	 */
	public void setPro1rel1spr5(final Sprint pro1rel1spr5) {
		this.pro1rel1spr5 = pro1rel1spr5;
	}

	/**
	 * @return the pro1rel1spr5
	 */
	public Sprint getPro1rel1spr5() {
		return this.pro1rel1spr5;
	}

	/**
	 * @param pro1rel2spr1
	 *            the pro1rel2spr1 to set
	 */
	public void setPro1rel2spr1(final Sprint pro1rel2spr1) {
		this.pro1rel2spr1 = pro1rel2spr1;
	}

	/**
	 * @return the pro1rel2spr1
	 */
	public Sprint getPro1rel2spr1() {
		return this.pro1rel2spr1;
	}

	/**
	 * @param pro1rel2spr2
	 *            the pro1rel2spr2 to set
	 */
	public void setPro1rel2spr2(final Sprint pro1rel2spr2) {
		this.pro1rel2spr2 = pro1rel2spr2;
	}

	/**
	 * @return the pro1rel2spr2
	 */
	public Sprint getPro1rel2spr2() {
		return this.pro1rel2spr2;
	}

	/**
	 * @param pro1rel2spr3
	 *            the pro1rel2spr3 to set
	 */
	public void setPro1rel2spr3(final Sprint pro1rel2spr3) {
		this.pro1rel2spr3 = pro1rel2spr3;
	}

	/**
	 * @return the pro1rel2spr3
	 */
	public Sprint getPro1rel2spr3() {
		return this.pro1rel2spr3;
	}

	/**
	 * @param pro1rel2spr4
	 *            the pro1rel2spr4 to set
	 */
	public void setPro1rel2spr4(final Sprint pro1rel2spr4) {
		this.pro1rel2spr4 = pro1rel2spr4;
	}

	/**
	 * @return the pro1rel2spr4
	 */
	public Sprint getPro1rel2spr4() {
		return this.pro1rel2spr4;
	}

	/**
	 * @param pro1rel2spr5
	 *            the pro1rel2spr5 to set
	 */
	public void setPro1rel2spr5(final Sprint pro1rel2spr5) {
		this.pro1rel2spr5 = pro1rel2spr5;
	}

	/**
	 * @return the pro1rel2spr5
	 */
	public Sprint getPro1rel2spr5() {
		return this.pro1rel2spr5;
	}

	/**
	 * @param pro2rel1spr1
	 *            the pro2rel1spr1 to set
	 */
	public void setPro2rel1spr1(final Sprint pro2rel1spr1) {
		this.pro2rel1spr1 = pro2rel1spr1;
	}

	/**
	 * @return the pro2rel1spr1
	 */
	public Sprint getPro2rel1spr1() {
		return this.pro2rel1spr1;
	}

	/**
	 * @param pro2rel1spr2
	 *            the pro2rel1spr2 to set
	 */
	public void setPro2rel1spr2(final Sprint pro2rel1spr2) {
		this.pro2rel1spr2 = pro2rel1spr2;
	}

	/**
	 * @return the pro2rel1spr2
	 */
	public Sprint getPro2rel1spr2() {
		return this.pro2rel1spr2;
	}

	/**
	 * @param pro2rel1spr3
	 *            the pro2rel1spr3 to set
	 */
	public void setPro2rel1spr3(final Sprint pro2rel1spr3) {
		this.pro2rel1spr3 = pro2rel1spr3;
	}

	/**
	 * @return the pro2rel1spr3
	 */
	public Sprint getPro2rel1spr3() {
		return this.pro2rel1spr3;
	}

	/**
	 * @param pro2rel1spr4
	 *            the pro2rel1spr4 to set
	 */
	public void setPro2rel1spr4(final Sprint pro2rel1spr4) {
		this.pro2rel1spr4 = pro2rel1spr4;
	}

	/**
	 * @return the pro2rel1spr4
	 */
	public Sprint getPro2rel1spr4() {
		return this.pro2rel1spr4;
	}

	/**
	 * @param pro2rel1spr5
	 *            the pro2rel1spr5 to set
	 */
	public void setPro2rel1spr5(final Sprint pro2rel1spr5) {
		this.pro2rel1spr5 = pro2rel1spr5;
	}

	/**
	 * @return the pro2rel1spr5
	 */
	public Sprint getPro2rel1spr5() {
		return this.pro2rel1spr5;
	}

	/**
	 * @param pro2rel2spr1
	 *            the pro2rel2spr1 to set
	 */
	public void setPro2rel2spr1(final Sprint pro2rel2spr1) {
		this.pro2rel2spr1 = pro2rel2spr1;
	}

	/**
	 * @return the pro2rel2spr1
	 */
	public Sprint getPro2rel2spr1() {
		return this.pro2rel2spr1;
	}

	/**
	 * @param pro2rel2spr2
	 *            the pro2rel2spr2 to set
	 */
	public void setPro2rel2spr2(final Sprint pro2rel2spr2) {
		this.pro2rel2spr2 = pro2rel2spr2;
	}

	/**
	 * @return the pro2rel2spr2
	 */
	public Sprint getPro2rel2spr2() {
		return this.pro2rel2spr2;
	}

	/**
	 * @param pro2rel2spr3
	 *            the pro2rel2spr3 to set
	 */
	public void setPro2rel2spr3(final Sprint pro2rel2spr3) {
		this.pro2rel2spr3 = pro2rel2spr3;
	}

	/**
	 * @return the pro2rel2spr3
	 */
	public Sprint getPro2rel2spr3() {
		return this.pro2rel2spr3;
	}

	/**
	 * @param pro2rel2spr4
	 *            the pro2rel2spr4 to set
	 */
	public void setPro2rel2spr4(final Sprint pro2rel2spr4) {
		this.pro2rel2spr4 = pro2rel2spr4;
	}

	/**
	 * @return the pro2rel2spr4
	 */
	public Sprint getPro2rel2spr4() {
		return this.pro2rel2spr4;
	}

	/**
	 * @param pro2rel2spr5
	 *            the pro2rel2spr5 to set
	 */
	public void setPro2rel2spr5(final Sprint pro2rel2spr5) {
		this.pro2rel2spr5 = pro2rel2spr5;
	}

	/**
	 * @return the pro2rel2spr5
	 */
	public Sprint getPro2rel2spr5() {
		return this.pro2rel2spr5;
	}

	/**
	 * @param pro1rel1spr1tas1
	 *            the pro1rel1spr1tas1 to set
	 */
	public void setPro1rel1spr1tas1(final Task pro1rel1spr1tas1) {
		this.pro1rel1spr1tas1 = pro1rel1spr1tas1;
	}

	/**
	 * @return the pro1rel1spr1tas1
	 */
	public Task getPro1rel1spr1tas1() {
		return this.pro1rel1spr1tas1;
	}

	/**
	 * @param pro1rel1spr1tas2
	 *            the pro1rel1spr1tas2 to set
	 */
	public void setPro1rel1spr1tas2(final Task pro1rel1spr1tas2) {
		this.pro1rel1spr1tas2 = pro1rel1spr1tas2;
	}

	/**
	 * @return the pro1rel1spr1tas2
	 */
	public Task getPro1rel1spr1tas2() {
		return this.pro1rel1spr1tas2;
	}

	/**
	 * @param pro1rel1spr1tas3
	 *            the pro1rel1spr1tas3 to set
	 */
	public void setPro1rel1spr1tas3(final Task pro1rel1spr1tas3) {
		this.pro1rel1spr1tas3 = pro1rel1spr1tas3;
	}

	/**
	 * @return the pro1rel1spr1tas3
	 */
	public Task getPro1rel1spr1tas3() {
		return this.pro1rel1spr1tas3;
	}

	/**
	 * @param pro1rel1spr1tas4
	 *            the pro1rel1spr1tas4 to set
	 */
	public void setPro1rel1spr1tas4(final Task pro1rel1spr1tas4) {
		this.pro1rel1spr1tas4 = pro1rel1spr1tas4;
	}

	/**
	 * @return the pro1rel1spr1tas4
	 */
	public Task getPro1rel1spr1tas4() {
		return this.pro1rel1spr1tas4;
	}

	/**
	 * @param pro1rel1spr1tas5
	 *            the pro1rel1spr1tas5 to set
	 */
	protected void setPro1rel1spr1tas5(final Task pro1rel1spr1tas5) {
		this.pro1rel1spr1tas5 = pro1rel1spr1tas5;
	}

	/**
	 * @return the pro1rel1spr1tas5
	 */
	protected Task getPro1rel1spr1tas5() {
		return this.pro1rel1spr1tas5;
	}

	/**
	 * @param pro1rel1spr2tas1
	 *            the pro1rel1spr2tas1 to set
	 */
	public void setPro1rel1spr2tas1(final Task pro1rel1spr2tas1) {
		this.pro1rel1spr2tas1 = pro1rel1spr2tas1;
	}

	/**
	 * @return the pro1rel1spr2tas1
	 */
	public Task getPro1rel1spr2tas1() {
		return this.pro1rel1spr2tas1;
	}

	/**
	 * @param pro1rel1spr2tas2
	 *            the pro1rel1spr2tas2 to set
	 */
	public void setPro1rel1spr2tas2(final Task pro1rel1spr2tas2) {
		this.pro1rel1spr2tas2 = pro1rel1spr2tas2;
	}

	/**
	 * @return the pro1rel1spr2tas2
	 */
	public Task getPro1rel1spr2tas2() {
		return this.pro1rel1spr2tas2;
	}

	/**
	 * @param pro1rel1spr2tas3
	 *            the pro1rel1spr2tas3 to set
	 */
	public void setPro1rel1spr2tas3(final Task pro1rel1spr2tas3) {
		this.pro1rel1spr2tas3 = pro1rel1spr2tas3;
	}

	/**
	 * @return the pro1rel1spr2tas3
	 */
	public Task getPro1rel1spr2tas3() {
		return this.pro1rel1spr2tas3;
	}

	/**
	 * @param pro1rel1spr2tas4
	 *            the pro1rel1spr2tas4 to set
	 */
	public void setPro1rel1spr2tas4(final Task pro1rel1spr2tas4) {
		this.pro1rel1spr2tas4 = pro1rel1spr2tas4;
	}

	/**
	 * @return the pro1rel1spr2tas4
	 */
	public Task getPro1rel1spr2tas4() {
		return this.pro1rel1spr2tas4;
	}

	/**
	 * @param pro1rel1spr2tas5
	 *            the pro1rel1spr2tas5 to set
	 */
	public void setPro1rel1spr2tas5(final Task pro1rel1spr2tas5) {
		this.pro1rel1spr2tas5 = pro1rel1spr2tas5;
	}

	/**
	 * @return the pro1rel1spr2tas5
	 */
	public Task getPro1rel1spr2tas5() {
		return this.pro1rel1spr2tas5;
	}

	/**
	 * @param pro1rel1spr3tas1
	 *            the pro1rel1spr3tas1 to set
	 */
	public void setPro1rel1spr3tas1(final Task pro1rel1spr3tas1) {
		this.pro1rel1spr3tas1 = pro1rel1spr3tas1;
	}

	/**
	 * @return the pro1rel1spr3tas1
	 */
	public Task getPro1rel1spr3tas1() {
		return this.pro1rel1spr3tas1;
	}

	/**
	 * @param pro1rel1spr3tas2
	 *            the pro1rel1spr3tas2 to set
	 */
	public void setPro1rel1spr3tas2(final Task pro1rel1spr3tas2) {
		this.pro1rel1spr3tas2 = pro1rel1spr3tas2;
	}

	/**
	 * @return the pro1rel1spr3tas2
	 */
	public Task getPro1rel1spr3tas2() {
		return this.pro1rel1spr3tas2;
	}

	/**
	 * @param pro1rel1spr3tas3
	 *            the pro1rel1spr3tas3 to set
	 */
	public void setPro1rel1spr3tas3(final Task pro1rel1spr3tas3) {
		this.pro1rel1spr3tas3 = pro1rel1spr3tas3;
	}

	/**
	 * @return the pro1rel1spr3tas3
	 */
	public Task getPro1rel1spr3tas3() {
		return this.pro1rel1spr3tas3;
	}

	/**
	 * @param pro1rel1spr3tas4
	 *            the pro1rel1spr3tas4 to set
	 */
	public void setPro1rel1spr3tas4(final Task pro1rel1spr3tas4) {
		this.pro1rel1spr3tas4 = pro1rel1spr3tas4;
	}

	/**
	 * @return the pro1rel1spr3tas4
	 */
	public Task getPro1rel1spr3tas4() {
		return this.pro1rel1spr3tas4;
	}

	/**
	 * @param pro1rel1spr3tas5
	 *            the pro1rel1spr3tas5 to set
	 */
	public void setPro1rel1spr3tas5(final Task pro1rel1spr3tas5) {
		this.pro1rel1spr3tas5 = pro1rel1spr3tas5;
	}

	/**
	 * @return the pro1rel1spr3tas5
	 */
	public Task getPro1rel1spr3tas5() {
		return this.pro1rel1spr3tas5;
	}

	/**
	 * @param pro1rel1spr4tas1
	 *            the pro1rel1spr4tas1 to set
	 */
	public void setPro1rel1spr4tas1(final Task pro1rel1spr4tas1) {
		this.pro1rel1spr4tas1 = pro1rel1spr4tas1;
	}

	/**
	 * @return the pro1rel1spr4tas1
	 */
	public Task getPro1rel1spr4tas1() {
		return this.pro1rel1spr4tas1;
	}

	/**
	 * @param pro1rel1spr4tas2
	 *            the pro1rel1spr4tas2 to set
	 */
	public void setPro1rel1spr4tas2(final Task pro1rel1spr4tas2) {
		this.pro1rel1spr4tas2 = pro1rel1spr4tas2;
	}

	/**
	 * @return the pro1rel1spr4tas2
	 */
	public Task getPro1rel1spr4tas2() {
		return this.pro1rel1spr4tas2;
	}

	/**
	 * @param pro1rel1spr4tas3
	 *            the pro1rel1spr4tas3 to set
	 */
	public void setPro1rel1spr4tas3(final Task pro1rel1spr4tas3) {
		this.pro1rel1spr4tas3 = pro1rel1spr4tas3;
	}

	/**
	 * @return the pro1rel1spr4tas3
	 */
	public Task getPro1rel1spr4tas3() {
		return this.pro1rel1spr4tas3;
	}

	/**
	 * @param pro1rel1spr4tas4
	 *            the pro1rel1spr4tas4 to set
	 */
	public void setPro1rel1spr4tas4(final Task pro1rel1spr4tas4) {
		this.pro1rel1spr4tas4 = pro1rel1spr4tas4;
	}

	/**
	 * @return the pro1rel1spr4tas4
	 */
	public Task getPro1rel1spr4tas4() {
		return this.pro1rel1spr4tas4;
	}

	/**
	 * @param pro1rel1spr4tas5
	 *            the pro1rel1spr4tas5 to set
	 */
	public void setPro1rel1spr4tas5(final Task pro1rel1spr4tas5) {
		this.pro1rel1spr4tas5 = pro1rel1spr4tas5;
	}

	/**
	 * @return the pro1rel1spr4tas5
	 */
	public Task getPro1rel1spr4tas5() {
		return this.pro1rel1spr4tas5;
	}

	/**
	 * @param pro1rel1spr5tas1
	 *            the pro1rel1spr5tas1 to set
	 */
	protected void setPro1rel1spr5tas1(final Task pro1rel1spr5tas1) {
		this.pro1rel1spr5tas1 = pro1rel1spr5tas1;
	}

	/**
	 * @return the pro1rel1spr5tas1
	 */
	protected Task getPro1rel1spr5tas1() {
		return this.pro1rel1spr5tas1;
	}

	/**
	 * @param pro1rel1spr5tas2
	 *            the pro1rel1spr5tas2 to set
	 */
	public void setPro1rel1spr5tas2(final Task pro1rel1spr5tas2) {
		this.pro1rel1spr5tas2 = pro1rel1spr5tas2;
	}

	/**
	 * @return the pro1rel1spr5tas2
	 */
	public Task getPro1rel1spr5tas2() {
		return this.pro1rel1spr5tas2;
	}

	/**
	 * @param pro1rel1spr5tas3
	 *            the pro1rel1spr5tas3 to set
	 */
	public void setPro1rel1spr5tas3(final Task pro1rel1spr5tas3) {
		this.pro1rel1spr5tas3 = pro1rel1spr5tas3;
	}

	/**
	 * @return the pro1rel1spr5tas3
	 */
	public Task getPro1rel1spr5tas3() {
		return this.pro1rel1spr5tas3;
	}

	/**
	 * @param pro1rel1spr5tas4
	 *            the pro1rel1spr5tas4 to set
	 */
	public void setPro1rel1spr5tas4(final Task pro1rel1spr5tas4) {
		this.pro1rel1spr5tas4 = pro1rel1spr5tas4;
	}

	/**
	 * @return the pro1rel1spr5tas4
	 */
	public Task getPro1rel1spr5tas4() {
		return this.pro1rel1spr5tas4;
	}

	/**
	 * @param pro1rel1spr5tas5
	 *            the pro1rel1spr5tas5 to set
	 */
	public void setPro1rel1spr5tas5(final Task pro1rel1spr5tas5) {
		this.pro1rel1spr5tas5 = pro1rel1spr5tas5;
	}

	/**
	 * @return the pro1rel1spr5tas5
	 */
	public Task getPro1rel1spr5tas5() {
		return this.pro1rel1spr5tas5;
	}

	/**
	 * @param pro1rel2spr1tas1
	 *            the pro1rel2spr1tas1 to set
	 */
	public void setPro1rel2spr1tas1(final Task pro1rel2spr1tas1) {
		this.pro1rel2spr1tas1 = pro1rel2spr1tas1;
	}

	/**
	 * @return the pro1rel2spr1tas1
	 */
	public Task getPro1rel2spr1tas1() {
		return this.pro1rel2spr1tas1;
	}

	/**
	 * @param pro1rel2spr1tas2
	 *            the pro1rel2spr1tas2 to set
	 */
	public void setPro1rel2spr1tas2(final Task pro1rel2spr1tas2) {
		this.pro1rel2spr1tas2 = pro1rel2spr1tas2;
	}

	/**
	 * @return the pro1rel2spr1tas2
	 */
	public Task getPro1rel2spr1tas2() {
		return this.pro1rel2spr1tas2;
	}

	/**
	 * @param pro1rel2spr1tas3
	 *            the pro1rel2spr1tas3 to set
	 */
	public void setPro1rel2spr1tas3(final Task pro1rel2spr1tas3) {
		this.pro1rel2spr1tas3 = pro1rel2spr1tas3;
	}

	/**
	 * @return the pro1rel2spr1tas3
	 */
	public Task getPro1rel2spr1tas3() {
		return this.pro1rel2spr1tas3;
	}

	/**
	 * @param pro1rel2spr1tas4
	 *            the pro1rel2spr1tas4 to set
	 */
	public void setPro1rel2spr1tas4(final Task pro1rel2spr1tas4) {
		this.pro1rel2spr1tas4 = pro1rel2spr1tas4;
	}

	/**
	 * @return the pro1rel2spr1tas4
	 */
	public Task getPro1rel2spr1tas4() {
		return this.pro1rel2spr1tas4;
	}

	/**
	 * @param pro1rel2spr1tas5
	 *            the pro1rel2spr1tas5 to set
	 */
	public void setPro1rel2spr1tas5(final Task pro1rel2spr1tas5) {
		this.pro1rel2spr1tas5 = pro1rel2spr1tas5;
	}

	/**
	 * @return the pro1rel2spr1tas5
	 */
	public Task getPro1rel2spr1tas5() {
		return this.pro1rel2spr1tas5;
	}

	/**
	 * @param pro1rel2spr2tas1
	 *            the pro1rel2spr2tas1 to set
	 */
	public void setPro1rel2spr2tas1(final Task pro1rel2spr2tas1) {
		this.pro1rel2spr2tas1 = pro1rel2spr2tas1;
	}

	/**
	 * @return the pro1rel2spr2tas1
	 */
	public Task getPro1rel2spr2tas1() {
		return this.pro1rel2spr2tas1;
	}

	/**
	 * @param pro1rel2spr2tas2
	 *            the pro1rel2spr2tas2 to set
	 */
	public void setPro1rel2spr2tas2(final Task pro1rel2spr2tas2) {
		this.pro1rel2spr2tas2 = pro1rel2spr2tas2;
	}

	/**
	 * @return the pro1rel2spr2tas2
	 */
	public Task getPro1rel2spr2tas2() {
		return this.pro1rel2spr2tas2;
	}

	/**
	 * @param pro1rel2spr2tas3
	 *            the pro1rel2spr2tas3 to set
	 */
	public void setPro1rel2spr2tas3(final Task pro1rel2spr2tas3) {
		this.pro1rel2spr2tas3 = pro1rel2spr2tas3;
	}

	/**
	 * @return the pro1rel2spr2tas3
	 */
	public Task getPro1rel2spr2tas3() {
		return this.pro1rel2spr2tas3;
	}

	/**
	 * @param pro1rel2spr2tas4
	 *            the pro1rel2spr2tas4 to set
	 */
	public void setPro1rel2spr2tas4(final Task pro1rel2spr2tas4) {
		this.pro1rel2spr2tas4 = pro1rel2spr2tas4;
	}

	/**
	 * @return the pro1rel2spr2tas4
	 */
	public Task getPro1rel2spr2tas4() {
		return this.pro1rel2spr2tas4;
	}

	/**
	 * @param pro1rel2spr2tas5
	 *            the pro1rel2spr2tas5 to set
	 */
	public void setPro1rel2spr2tas5(final Task pro1rel2spr2tas5) {
		this.pro1rel2spr2tas5 = pro1rel2spr2tas5;
	}

	/**
	 * @return the pro1rel2spr2tas5
	 */
	public Task getPro1rel2spr2tas5() {
		return this.pro1rel2spr2tas5;
	}

	/**
	 * @param pro1rel2spr3tas1
	 *            the pro1rel2spr3tas1 to set
	 */
	public void setPro1rel2spr3tas1(final Task pro1rel2spr3tas1) {
		this.pro1rel2spr3tas1 = pro1rel2spr3tas1;
	}

	/**
	 * @return the pro1rel2spr3tas1
	 */
	public Task getPro1rel2spr3tas1() {
		return this.pro1rel2spr3tas1;
	}

	/**
	 * @param pro1rel2spr3tas2
	 *            the pro1rel2spr3tas2 to set
	 */
	public void setPro1rel2spr3tas2(final Task pro1rel2spr3tas2) {
		this.pro1rel2spr3tas2 = pro1rel2spr3tas2;
	}

	/**
	 * @return the pro1rel2spr3tas2
	 */
	public Task getPro1rel2spr3tas2() {
		return this.pro1rel2spr3tas2;
	}

	/**
	 * @param pro1rel2spr3tas3
	 *            the pro1rel2spr3tas3 to set
	 */
	public void setPro1rel2spr3tas3(final Task pro1rel2spr3tas3) {
		this.pro1rel2spr3tas3 = pro1rel2spr3tas3;
	}

	/**
	 * @return the pro1rel2spr3tas3
	 */
	public Task getPro1rel2spr3tas3() {
		return this.pro1rel2spr3tas3;
	}

	/**
	 * @param pro1rel2spr3tas4
	 *            the pro1rel2spr3tas4 to set
	 */
	public void setPro1rel2spr3tas4(final Task pro1rel2spr3tas4) {
		this.pro1rel2spr3tas4 = pro1rel2spr3tas4;
	}

	/**
	 * @return the pro1rel2spr3tas4
	 */
	public Task getPro1rel2spr3tas4() {
		return this.pro1rel2spr3tas4;
	}

	/**
	 * @param pro1rel2spr3tas5
	 *            the pro1rel2spr3tas5 to set
	 */
	public void setPro1rel2spr3tas5(final Task pro1rel2spr3tas5) {
		this.pro1rel2spr3tas5 = pro1rel2spr3tas5;
	}

	/**
	 * @return the pro1rel2spr3tas5
	 */
	public Task getPro1rel2spr3tas5() {
		return this.pro1rel2spr3tas5;
	}

	/**
	 * @param pro1rel2spr4tas1
	 *            the pro1rel2spr4tas1 to set
	 */
	public void setPro1rel2spr4tas1(final Task pro1rel2spr4tas1) {
		this.pro1rel2spr4tas1 = pro1rel2spr4tas1;
	}

	/**
	 * @return the pro1rel2spr4tas1
	 */
	public Task getPro1rel2spr4tas1() {
		return this.pro1rel2spr4tas1;
	}

	/**
	 * @param pro1rel2spr4tas2
	 *            the pro1rel2spr4tas2 to set
	 */
	public void setPro1rel2spr4tas2(final Task pro1rel2spr4tas2) {
		this.pro1rel2spr4tas2 = pro1rel2spr4tas2;
	}

	/**
	 * @return the pro1rel2spr4tas2
	 */
	public Task getPro1rel2spr4tas2() {
		return this.pro1rel2spr4tas2;
	}

	/**
	 * @param pro1rel2spr4tas3
	 *            the pro1rel2spr4tas3 to set
	 */
	public void setPro1rel2spr4tas3(final Task pro1rel2spr4tas3) {
		this.pro1rel2spr4tas3 = pro1rel2spr4tas3;
	}

	/**
	 * @return the pro1rel2spr4tas3
	 */
	public Task getPro1rel2spr4tas3() {
		return this.pro1rel2spr4tas3;
	}

	/**
	 * @param pro1rel2spr4tas4
	 *            the pro1rel2spr4tas4 to set
	 */
	public void setPro1rel2spr4tas4(final Task pro1rel2spr4tas4) {
		this.pro1rel2spr4tas4 = pro1rel2spr4tas4;
	}

	/**
	 * @return the pro1rel2spr4tas4
	 */
	public Task getPro1rel2spr4tas4() {
		return this.pro1rel2spr4tas4;
	}

	/**
	 * @param pro1rel2spr4tas5
	 *            the pro1rel2spr4tas5 to set
	 */
	public void setPro1rel2spr4tas5(final Task pro1rel2spr4tas5) {
		this.pro1rel2spr4tas5 = pro1rel2spr4tas5;
	}

	/**
	 * @return the pro1rel2spr4tas5
	 */
	public Task getPro1rel2spr4tas5() {
		return this.pro1rel2spr4tas5;
	}

	/**
	 * @param pro1rel2spr5tas1
	 *            the pro1rel2spr5tas1 to set
	 */
	public void setPro1rel2spr5tas1(final Task pro1rel2spr5tas1) {
		this.pro1rel2spr5tas1 = pro1rel2spr5tas1;
	}

	/**
	 * @return the pro1rel2spr5tas1
	 */
	public Task getPro1rel2spr5tas1() {
		return this.pro1rel2spr5tas1;
	}

	/**
	 * @param pro1rel2spr5tas2
	 *            the pro1rel2spr5tas2 to set
	 */
	public void setPro1rel2spr5tas2(final Task pro1rel2spr5tas2) {
		this.pro1rel2spr5tas2 = pro1rel2spr5tas2;
	}

	/**
	 * @return the pro1rel2spr5tas2
	 */
	public Task getPro1rel2spr5tas2() {
		return this.pro1rel2spr5tas2;
	}

	/**
	 * @param pro1rel2spr5tas3
	 *            the pro1rel2spr5tas3 to set
	 */
	public void setPro1rel2spr5tas3(final Task pro1rel2spr5tas3) {
		this.pro1rel2spr5tas3 = pro1rel2spr5tas3;
	}

	/**
	 * @return the pro1rel2spr5tas3
	 */
	public Task getPro1rel2spr5tas3() {
		return this.pro1rel2spr5tas3;
	}

	/**
	 * @param pro1rel2spr5tas4
	 *            the pro1rel2spr5tas4 to set
	 */
	public void setPro1rel2spr5tas4(final Task pro1rel2spr5tas4) {
		this.pro1rel2spr5tas4 = pro1rel2spr5tas4;
	}

	/**
	 * @return the pro1rel2spr5tas4
	 */
	public Task getPro1rel2spr5tas4() {
		return this.pro1rel2spr5tas4;
	}

	/**
	 * @param pro1rel2spr5tas5
	 *            the pro1rel2spr5tas5 to set
	 */
	public void setPro1rel2spr5tas5(final Task pro1rel2spr5tas5) {
		this.pro1rel2spr5tas5 = pro1rel2spr5tas5;
	}

	/**
	 * @return the pro1rel2spr5tas5
	 */
	public Task getPro1rel2spr5tas5() {
		return this.pro1rel2spr5tas5;
	}

	/**
	 * @param pro2rel1spr1tas1
	 *            the pro2rel1spr1tas1 to set
	 */
	public void setPro2rel1spr1tas1(final Task pro2rel1spr1tas1) {
		this.pro2rel1spr1tas1 = pro2rel1spr1tas1;
	}

	/**
	 * @return the pro2rel1spr1tas1
	 */
	public Task getPro2rel1spr1tas1() {
		return this.pro2rel1spr1tas1;
	}

	/**
	 * @param pro2rel1spr1tas2
	 *            the pro2rel1spr1tas2 to set
	 */
	public void setPro2rel1spr1tas2(final Task pro2rel1spr1tas2) {
		this.pro2rel1spr1tas2 = pro2rel1spr1tas2;
	}

	/**
	 * @return the pro2rel1spr1tas2
	 */
	public Task getPro2rel1spr1tas2() {
		return this.pro2rel1spr1tas2;
	}

	/**
	 * @param pro2rel1spr1tas3
	 *            the pro2rel1spr1tas3 to set
	 */
	public void setPro2rel1spr1tas3(final Task pro2rel1spr1tas3) {
		this.pro2rel1spr1tas3 = pro2rel1spr1tas3;
	}

	/**
	 * @return the pro2rel1spr1tas3
	 */
	public Task getPro2rel1spr1tas3() {
		return this.pro2rel1spr1tas3;
	}

	/**
	 * @param pro2rel1spr1tas4
	 *            the pro2rel1spr1tas4 to set
	 */
	public void setPro2rel1spr1tas4(final Task pro2rel1spr1tas4) {
		this.pro2rel1spr1tas4 = pro2rel1spr1tas4;
	}

	/**
	 * @return the pro2rel1spr1tas4
	 */
	public Task getPro2rel1spr1tas4() {
		return this.pro2rel1spr1tas4;
	}

	/**
	 * @param pro2rel1spr1tas5
	 *            the pro2rel1spr1tas5 to set
	 */
	public void setPro2rel1spr1tas5(final Task pro2rel1spr1tas5) {
		this.pro2rel1spr1tas5 = pro2rel1spr1tas5;
	}

	/**
	 * @return the pro2rel1spr1tas5
	 */
	public Task getPro2rel1spr1tas5() {
		return this.pro2rel1spr1tas5;
	}

	/**
	 * @param pro2rel1spr2tas1
	 *            the pro2rel1spr2tas1 to set
	 */
	public void setPro2rel1spr2tas1(final Task pro2rel1spr2tas1) {
		this.pro2rel1spr2tas1 = pro2rel1spr2tas1;
	}

	/**
	 * @return the pro2rel1spr2tas1
	 */
	public Task getPro2rel1spr2tas1() {
		return this.pro2rel1spr2tas1;
	}

	/**
	 * @param pro2rel1spr2tas2
	 *            the pro2rel1spr2tas2 to set
	 */
	public void setPro2rel1spr2tas2(final Task pro2rel1spr2tas2) {
		this.pro2rel1spr2tas2 = pro2rel1spr2tas2;
	}

	/**
	 * @return the pro2rel1spr2tas2
	 */
	public Task getPro2rel1spr2tas2() {
		return this.pro2rel1spr2tas2;
	}

	/**
	 * @param pro2rel1spr2tas3
	 *            the pro2rel1spr2tas3 to set
	 */
	public void setPro2rel1spr2tas3(final Task pro2rel1spr2tas3) {
		this.pro2rel1spr2tas3 = pro2rel1spr2tas3;
	}

	/**
	 * @return the pro2rel1spr2tas3
	 */
	public Task getPro2rel1spr2tas3() {
		return this.pro2rel1spr2tas3;
	}

	/**
	 * @param pro2rel1spr2tas4
	 *            the pro2rel1spr2tas4 to set
	 */
	public void setPro2rel1spr2tas4(final Task pro2rel1spr2tas4) {
		this.pro2rel1spr2tas4 = pro2rel1spr2tas4;
	}

	/**
	 * @return the pro2rel1spr2tas4
	 */
	public Task getPro2rel1spr2tas4() {
		return this.pro2rel1spr2tas4;
	}

	/**
	 * @param pro2rel1spr2tas5
	 *            the pro2rel1spr2tas5 to set
	 */
	public void setPro2rel1spr2tas5(final Task pro2rel1spr2tas5) {
		this.pro2rel1spr2tas5 = pro2rel1spr2tas5;
	}

	/**
	 * @return the pro2rel1spr2tas5
	 */
	public Task getPro2rel1spr2tas5() {
		return this.pro2rel1spr2tas5;
	}

	/**
	 * @param pro2rel1spr3tas1
	 *            the pro2rel1spr3tas1 to set
	 */
	public void setPro2rel1spr3tas1(final Task pro2rel1spr3tas1) {
		this.pro2rel1spr3tas1 = pro2rel1spr3tas1;
	}

	/**
	 * @return the pro2rel1spr3tas1
	 */
	public Task getPro2rel1spr3tas1() {
		return this.pro2rel1spr3tas1;
	}

	/**
	 * @param pro2rel1spr3tas2
	 *            the pro2rel1spr3tas2 to set
	 */
	public void setPro2rel1spr3tas2(final Task pro2rel1spr3tas2) {
		this.pro2rel1spr3tas2 = pro2rel1spr3tas2;
	}

	/**
	 * @return the pro2rel1spr3tas2
	 */
	public Task getPro2rel1spr3tas2() {
		return this.pro2rel1spr3tas2;
	}

	/**
	 * @param pro2rel1spr3tas3
	 *            the pro2rel1spr3tas3 to set
	 */
	public void setPro2rel1spr3tas3(final Task pro2rel1spr3tas3) {
		this.pro2rel1spr3tas3 = pro2rel1spr3tas3;
	}

	/**
	 * @return the pro2rel1spr3tas3
	 */
	public Task getPro2rel1spr3tas3() {
		return this.pro2rel1spr3tas3;
	}

	/**
	 * @param pro2rel1spr3tas4
	 *            the pro2rel1spr3tas4 to set
	 */
	public void setPro2rel1spr3tas4(final Task pro2rel1spr3tas4) {
		this.pro2rel1spr3tas4 = pro2rel1spr3tas4;
	}

	/**
	 * @return the pro2rel1spr3tas4
	 */
	public Task getPro2rel1spr3tas4() {
		return this.pro2rel1spr3tas4;
	}

	/**
	 * @param pro2rel1spr3tas5
	 *            the pro2rel1spr3tas5 to set
	 */
	public void setPro2rel1spr3tas5(final Task pro2rel1spr3tas5) {
		this.pro2rel1spr3tas5 = pro2rel1spr3tas5;
	}

	/**
	 * @return the pro2rel1spr3tas5
	 */
	public Task getPro2rel1spr3tas5() {
		return this.pro2rel1spr3tas5;
	}

	/**
	 * @param pro2rel1spr4tas1
	 *            the pro2rel1spr4tas1 to set
	 */
	public void setPro2rel1spr4tas1(final Task pro2rel1spr4tas1) {
		this.pro2rel1spr4tas1 = pro2rel1spr4tas1;
	}

	/**
	 * @return the pro2rel1spr4tas1
	 */
	public Task getPro2rel1spr4tas1() {
		return this.pro2rel1spr4tas1;
	}

	/**
	 * @param pro2rel1spr4tas2
	 *            the pro2rel1spr4tas2 to set
	 */
	protected void setPro2rel1spr4tas2(final Task pro2rel1spr4tas2) {
		this.pro2rel1spr4tas2 = pro2rel1spr4tas2;
	}

	/**
	 * @return the pro2rel1spr4tas2
	 */
	protected Task getPro2rel1spr4tas2() {
		return this.pro2rel1spr4tas2;
	}

	/**
	 * @param pro2rel1spr4tas3
	 *            the pro2rel1spr4tas3 to set
	 */
	protected void setPro2rel1spr4tas3(final Task pro2rel1spr4tas3) {
		this.pro2rel1spr4tas3 = pro2rel1spr4tas3;
	}

	/**
	 * @return the pro2rel1spr4tas3
	 */
	protected Task getPro2rel1spr4tas3() {
		return this.pro2rel1spr4tas3;
	}

	/**
	 * @param pro2rel1spr4tas4
	 *            the pro2rel1spr4tas4 to set
	 */
	protected void setPro2rel1spr4tas4(final Task pro2rel1spr4tas4) {
		this.pro2rel1spr4tas4 = pro2rel1spr4tas4;
	}

	/**
	 * @return the pro2rel1spr4tas4
	 */
	protected Task getPro2rel1spr4tas4() {
		return this.pro2rel1spr4tas4;
	}

	/**
	 * @param pro2rel1spr4tas5
	 *            the pro2rel1spr4tas5 to set
	 */
	protected void setPro2rel1spr4tas5(final Task pro2rel1spr4tas5) {
		this.pro2rel1spr4tas5 = pro2rel1spr4tas5;
	}

	/**
	 * @return the pro2rel1spr4tas5
	 */
	protected Task getPro2rel1spr4tas5() {
		return this.pro2rel1spr4tas5;
	}

	/**
	 * @param pro2rel1spr5tas2
	 *            the pro2rel1spr5tas2 to set
	 */
	protected void setPro2rel1spr5tas2(final Task pro2rel1spr5tas2) {
		this.pro2rel1spr5tas2 = pro2rel1spr5tas2;
	}

	/**
	 * @return the pro2rel1spr5tas2
	 */
	protected Task getPro2rel1spr5tas2() {
		return this.pro2rel1spr5tas2;
	}

	/**
	 * @param pro2rel1spr5tas3
	 *            the pro2rel1spr5tas3 to set
	 */
	protected void setPro2rel1spr5tas3(final Task pro2rel1spr5tas3) {
		this.pro2rel1spr5tas3 = pro2rel1spr5tas3;
	}

	/**
	 * @return the pro2rel1spr5tas3
	 */
	protected Task getPro2rel1spr5tas3() {
		return this.pro2rel1spr5tas3;
	}

	/**
	 * @param pro2rel1spr5tas4
	 *            the pro2rel1spr5tas4 to set
	 */
	protected void setPro2rel1spr5tas4(final Task pro2rel1spr5tas4) {
		this.pro2rel1spr5tas4 = pro2rel1spr5tas4;
	}

	/**
	 * @return the pro2rel1spr5tas4
	 */
	protected Task getPro2rel1spr5tas4() {
		return this.pro2rel1spr5tas4;
	}

	/**
	 * @param pro2rel1spr5tas5
	 *            the pro2rel1spr5tas5 to set
	 */
	protected void setPro2rel1spr5tas5(final Task pro2rel1spr5tas5) {
		this.pro2rel1spr5tas5 = pro2rel1spr5tas5;
	}

	/**
	 * @return the pro2rel1spr5tas5
	 */
	protected Task getPro2rel1spr5tas5() {
		return this.pro2rel1spr5tas5;
	}

	/**
	 * @param pro2rel2spr1tas1
	 *            the pro2rel2spr1tas1 to set
	 */
	protected void setPro2rel2spr1tas1(final Task pro2rel2spr1tas1) {
		this.pro2rel2spr1tas1 = pro2rel2spr1tas1;
	}

	/**
	 * @return the pro2rel2spr1tas1
	 */
	protected Task getPro2rel2spr1tas1() {
		return this.pro2rel2spr1tas1;
	}

	/**
	 * @param pro2rel2spr1tas2
	 *            the pro2rel2spr1tas2 to set
	 */
	protected void setPro2rel2spr1tas2(final Task pro2rel2spr1tas2) {
		this.pro2rel2spr1tas2 = pro2rel2spr1tas2;
	}

	/**
	 * @return the pro2rel2spr1tas2
	 */
	protected Task getPro2rel2spr1tas2() {
		return this.pro2rel2spr1tas2;
	}

	/**
	 * @param pro2rel2spr1tas3
	 *            the pro2rel2spr1tas3 to set
	 */
	protected void setPro2rel2spr1tas3(final Task pro2rel2spr1tas3) {
		this.pro2rel2spr1tas3 = pro2rel2spr1tas3;
	}

	/**
	 * @return the pro2rel2spr1tas3
	 */
	protected Task getPro2rel2spr1tas3() {
		return this.pro2rel2spr1tas3;
	}

	/**
	 * @param pro2rel2spr1tas4
	 *            the pro2rel2spr1tas4 to set
	 */
	protected void setPro2rel2spr1tas4(final Task pro2rel2spr1tas4) {
		this.pro2rel2spr1tas4 = pro2rel2spr1tas4;
	}

	/**
	 * @return the pro2rel2spr1tas4
	 */
	protected Task getPro2rel2spr1tas4() {
		return this.pro2rel2spr1tas4;
	}

	/**
	 * @param pro2rel2spr1tas5
	 *            the pro2rel2spr1tas5 to set
	 */
	protected void setPro2rel2spr1tas5(final Task pro2rel2spr1tas5) {
		this.pro2rel2spr1tas5 = pro2rel2spr1tas5;
	}

	/**
	 * @return the pro2rel2spr1tas5
	 */
	protected Task getPro2rel2spr1tas5() {
		return this.pro2rel2spr1tas5;
	}

	/**
	 * @param pro2rel2spr2tas1
	 *            the pro2rel2spr2tas1 to set
	 */
	protected void setPro2rel2spr2tas1(final Task pro2rel2spr2tas1) {
		this.pro2rel2spr2tas1 = pro2rel2spr2tas1;
	}

	/**
	 * @return the pro2rel2spr2tas1
	 */
	protected Task getPro2rel2spr2tas1() {
		return this.pro2rel2spr2tas1;
	}

	/**
	 * @param pro2rel2spr2tas2
	 *            the pro2rel2spr2tas2 to set
	 */
	protected void setPro2rel2spr2tas2(final Task pro2rel2spr2tas2) {
		this.pro2rel2spr2tas2 = pro2rel2spr2tas2;
	}

	/**
	 * @return the pro2rel2spr2tas2
	 */
	protected Task getPro2rel2spr2tas2() {
		return this.pro2rel2spr2tas2;
	}

	/**
	 * @param pro2rel2spr2tas3
	 *            the pro2rel2spr2tas3 to set
	 */
	protected void setPro2rel2spr2tas3(final Task pro2rel2spr2tas3) {
		this.pro2rel2spr2tas3 = pro2rel2spr2tas3;
	}

	/**
	 * @return the pro2rel2spr2tas3
	 */
	protected Task getPro2rel2spr2tas3() {
		return this.pro2rel2spr2tas3;
	}

	/**
	 * @param pro2rel2spr2tas4
	 *            the pro2rel2spr2tas4 to set
	 */
	protected void setPro2rel2spr2tas4(final Task pro2rel2spr2tas4) {
		this.pro2rel2spr2tas4 = pro2rel2spr2tas4;
	}

	/**
	 * @return the pro2rel2spr2tas4
	 */
	protected Task getPro2rel2spr2tas4() {
		return this.pro2rel2spr2tas4;
	}

	/**
	 * @param pro2rel2spr2tas5
	 *            the pro2rel2spr2tas5 to set
	 */
	protected void setPro2rel2spr2tas5(final Task pro2rel2spr2tas5) {
		this.pro2rel2spr2tas5 = pro2rel2spr2tas5;
	}

	/**
	 * @return the pro2rel2spr2tas5
	 */
	protected Task getPro2rel2spr2tas5() {
		return this.pro2rel2spr2tas5;
	}

	/**
	 * @param pro2rel2spr3tas1
	 *            the pro2rel2spr3tas1 to set
	 */
	protected void setPro2rel2spr3tas1(final Task pro2rel2spr3tas1) {
		this.pro2rel2spr3tas1 = pro2rel2spr3tas1;
	}

	/**
	 * @return the pro2rel2spr3tas1
	 */
	protected Task getPro2rel2spr3tas1() {
		return this.pro2rel2spr3tas1;
	}

	/**
	 * @param pro2rel2spr3tas2
	 *            the pro2rel2spr3tas2 to set
	 */
	protected void setPro2rel2spr3tas2(final Task pro2rel2spr3tas2) {
		this.pro2rel2spr3tas2 = pro2rel2spr3tas2;
	}

	/**
	 * @return the pro2rel2spr3tas2
	 */
	protected Task getPro2rel2spr3tas2() {
		return this.pro2rel2spr3tas2;
	}

	/**
	 * @param pro2rel2spr3tas3
	 *            the pro2rel2spr3tas3 to set
	 */
	protected void setPro2rel2spr3tas3(final Task pro2rel2spr3tas3) {
		this.pro2rel2spr3tas3 = pro2rel2spr3tas3;
	}

	/**
	 * @return the pro2rel2spr3tas3
	 */
	protected Task getPro2rel2spr3tas3() {
		return this.pro2rel2spr3tas3;
	}

	/**
	 * @param pro2rel2spr3tas4
	 *            the pro2rel2spr3tas4 to set
	 */
	protected void setPro2rel2spr3tas4(final Task pro2rel2spr3tas4) {
		this.pro2rel2spr3tas4 = pro2rel2spr3tas4;
	}

	/**
	 * @return the pro2rel2spr3tas4
	 */
	protected Task getPro2rel2spr3tas4() {
		return this.pro2rel2spr3tas4;
	}

	/**
	 * @param pro2rel2spr3tas5
	 *            the pro2rel2spr3tas5 to set
	 */
	protected void setPro2rel2spr3tas5(final Task pro2rel2spr3tas5) {
		this.pro2rel2spr3tas5 = pro2rel2spr3tas5;
	}

	/**
	 * @return the pro2rel2spr3tas5
	 */
	protected Task getPro2rel2spr3tas5() {
		return this.pro2rel2spr3tas5;
	}

	/**
	 * @param pro2rel2spr4tas2
	 *            the pro2rel2spr4tas2 to set
	 */
	protected void setPro2rel2spr4tas2(final Task pro2rel2spr4tas2) {
		this.pro2rel2spr4tas2 = pro2rel2spr4tas2;
	}

	/**
	 * @return the pro2rel2spr4tas2
	 */
	protected Task getPro2rel2spr4tas2() {
		return this.pro2rel2spr4tas2;
	}

	/**
	 * @param pro2rel2spr4tas1
	 *            the pro2rel2spr4tas1 to set
	 */
	protected void setPro2rel2spr4tas1(final Task pro2rel2spr4tas1) {
		this.pro2rel2spr4tas1 = pro2rel2spr4tas1;
	}

	/**
	 * @return the pro2rel2spr4tas1
	 */
	protected Task getPro2rel2spr4tas1() {
		return this.pro2rel2spr4tas1;
	}

	/**
	 * @param pro2rel2spr4tas3
	 *            the pro2rel2spr4tas3 to set
	 */
	protected void setPro2rel2spr4tas3(final Task pro2rel2spr4tas3) {
		this.pro2rel2spr4tas3 = pro2rel2spr4tas3;
	}

	/**
	 * @return the pro2rel2spr4tas3
	 */
	protected Task getPro2rel2spr4tas3() {
		return this.pro2rel2spr4tas3;
	}

	/**
	 * @param pro2rel2spr4tas4
	 *            the pro2rel2spr4tas4 to set
	 */
	protected void setPro2rel2spr4tas4(final Task pro2rel2spr4tas4) {
		this.pro2rel2spr4tas4 = pro2rel2spr4tas4;
	}

	/**
	 * @return the pro2rel2spr4tas4
	 */
	protected Task getPro2rel2spr4tas4() {
		return this.pro2rel2spr4tas4;
	}

	/**
	 * @param pro2rel2spr4tas5
	 *            the pro2rel2spr4tas5 to set
	 */
	protected void setPro2rel2spr4tas5(final Task pro2rel2spr4tas5) {
		this.pro2rel2spr4tas5 = pro2rel2spr4tas5;
	}

	/**
	 * @return the pro2rel2spr4tas5
	 */
	protected Task getPro2rel2spr4tas5() {
		return this.pro2rel2spr4tas5;
	}

	/**
	 * @param pro2rel2spr5tas1
	 *            the pro2rel2spr5tas1 to set
	 */
	protected void setPro2rel2spr5tas1(final Task pro2rel2spr5tas1) {
		this.pro2rel2spr5tas1 = pro2rel2spr5tas1;
	}

	/**
	 * @return the pro2rel2spr5tas1
	 */
	protected Task getPro2rel2spr5tas1() {
		return this.pro2rel2spr5tas1;
	}

	/**
	 * @param pro2rel2spr5tas2
	 *            the pro2rel2spr5tas2 to set
	 */
	protected void setPro2rel2spr5tas2(final Task pro2rel2spr5tas2) {
		this.pro2rel2spr5tas2 = pro2rel2spr5tas2;
	}

	/**
	 * @return the pro2rel2spr5tas2
	 */
	protected Task getPro2rel2spr5tas2() {
		return this.pro2rel2spr5tas2;
	}

	/**
	 * @param pro2rel2spr5tas3
	 *            the pro2rel2spr5tas3 to set
	 */
	protected void setPro2rel2spr5tas3(final Task pro2rel2spr5tas3) {
		this.pro2rel2spr5tas3 = pro2rel2spr5tas3;
	}

	/**
	 * @return the pro2rel2spr5tas3
	 */
	protected Task getPro2rel2spr5tas3() {
		return this.pro2rel2spr5tas3;
	}

	/**
	 * @param pro2rel2spr5tas4
	 *            the pro2rel2spr5tas4 to set
	 */
	protected void setPro2rel2spr5tas4(final Task pro2rel2spr5tas4) {
		this.pro2rel2spr5tas4 = pro2rel2spr5tas4;
	}

	/**
	 * @return the pro2rel2spr5tas4
	 */
	protected Task getPro2rel2spr5tas4() {
		return this.pro2rel2spr5tas4;
	}

	/**
	 * @param pro2rel2spr5tas5
	 *            the pro2rel2spr5tas5 to set
	 */
	protected void setPro2rel2spr5tas5(final Task pro2rel2spr5tas5) {
		this.pro2rel2spr5tas5 = pro2rel2spr5tas5;
	}

	/**
	 * @return the pro2rel2spr5tas5
	 */
	protected Task getPro2rel2spr5tas5() {
		return this.pro2rel2spr5tas5;
	}

	/**
	 * @param pro2rel1spr5tas1
	 *            the pro2rel1spr5tas1 to set
	 */
	protected void setPro2rel1spr5tas1(final Task pro2rel1spr5tas1) {
		this.pro2rel1spr5tas1 = pro2rel1spr5tas1;
	}

	/**
	 * @return the pro2rel1spr5tas1
	 */
	protected Task getPro2rel1spr5tas1() {
		return this.pro2rel1spr5tas1;
	}

	/**
	 * @param projekt3
	 *            the projekt3 to set
	 */
	protected void setProjekt3(final Project projekt3) {
		this.projekt3 = projekt3;
	}

	/**
	 * @return the projekt3
	 */
	protected Project getProjekt3() {
		return this.projekt3;
	}

	/**
	 * @param pro3rel1
	 *            the pro3rel1 to set
	 */
	protected void setPro3rel1(final Release pro3rel1) {
		this.pro3rel1 = pro3rel1;
	}

	/**
	 * @return the pro3rel1
	 */
	protected Release getPro3rel1() {
		return this.pro3rel1;
	}

	/**
	 * @param pro3rel2
	 *            the pro3rel2 to set
	 */
	protected void setPro3rel2(final Release pro3rel2) {
		this.pro3rel2 = pro3rel2;
	}

	/**
	 * @return the pro3rel2
	 */
	protected Release getPro3rel2() {
		return this.pro3rel2;
	}

	/**
	 * @param pro3rel1spr1
	 *            the pro3rel1spr1 to set
	 */
	protected void setPro3rel1spr1(final Sprint pro3rel1spr1) {
		this.pro3rel1spr1 = pro3rel1spr1;
	}

	/**
	 * @return the pro3rel1spr1
	 */
	protected Sprint getPro3rel1spr1() {
		return this.pro3rel1spr1;
	}

	/**
	 * @param pro3rel1spr2
	 *            the pro3rel1spr2 to set
	 */
	protected void setPro3rel1spr2(final Sprint pro3rel1spr2) {
		this.pro3rel1spr2 = pro3rel1spr2;
	}

	/**
	 * @return the pro3rel1spr2
	 */
	protected Sprint getPro3rel1spr2() {
		return this.pro3rel1spr2;
	}

	/**
	 * @param pro3rel1spr3
	 *            the pro3rel1spr3 to set
	 */
	protected void setPro3rel1spr3(final Sprint pro3rel1spr3) {
		this.pro3rel1spr3 = pro3rel1spr3;
	}

	/**
	 * @return the pro3rel1spr3
	 */
	protected Sprint getPro3rel1spr3() {
		return this.pro3rel1spr3;
	}

	/**
	 * @param pro3rel1spr4
	 *            the pro3rel1spr4 to set
	 */
	protected void setPro3rel1spr4(final Sprint pro3rel1spr4) {
		this.pro3rel1spr4 = pro3rel1spr4;
	}

	/**
	 * @return the pro3rel1spr4
	 */
	protected Sprint getPro3rel1spr4() {
		return this.pro3rel1spr4;
	}

	/**
	 * @param pro3rel1spr5
	 *            the pro3rel1spr5 to set
	 */
	protected void setPro3rel1spr5(final Sprint pro3rel1spr5) {
		this.pro3rel1spr5 = pro3rel1spr5;
	}

	/**
	 * @return the pro3rel1spr5
	 */
	protected Sprint getPro3rel1spr5() {
		return this.pro3rel1spr5;
	}

	/**
	 * @param pro3rel2spr1
	 *            the pro3rel2spr1 to set
	 */
	protected void setPro3rel2spr1(final Sprint pro3rel2spr1) {
		this.pro3rel2spr1 = pro3rel2spr1;
	}

	/**
	 * @return the pro3rel2spr1
	 */
	protected Sprint getPro3rel2spr1() {
		return this.pro3rel2spr1;
	}

	/**
	 * @param pro3rel2spr2
	 *            the pro3rel2spr2 to set
	 */
	protected void setPro3rel2spr2(final Sprint pro3rel2spr2) {
		this.pro3rel2spr2 = pro3rel2spr2;
	}

	/**
	 * @return the pro3rel2spr2
	 */
	protected Sprint getPro3rel2spr2() {
		return this.pro3rel2spr2;
	}

	/**
	 * @param pro3rel2spr3
	 *            the pro3rel2spr3 to set
	 */
	protected void setPro3rel2spr3(final Sprint pro3rel2spr3) {
		this.pro3rel2spr3 = pro3rel2spr3;
	}

	/**
	 * @return the pro3rel2spr3
	 */
	protected Sprint getPro3rel2spr3() {
		return this.pro3rel2spr3;
	}

	/**
	 * @param pro3rel2spr4
	 *            the pro3rel2spr4 to set
	 */
	protected void setPro3rel2spr4(final Sprint pro3rel2spr4) {
		this.pro3rel2spr4 = pro3rel2spr4;
	}

	/**
	 * @return the pro3rel2spr4
	 */
	protected Sprint getPro3rel2spr4() {
		return this.pro3rel2spr4;
	}

	/**
	 * @param pro3rel2spr5
	 *            the pro3rel2spr5 to set
	 */
	protected void setPro3rel2spr5(final Sprint pro3rel2spr5) {
		this.pro3rel2spr5 = pro3rel2spr5;
	}

	/**
	 * @return the pro3rel2spr5
	 */
	protected Sprint getPro3rel2spr5() {
		return this.pro3rel2spr5;
	}

	/**
	 * @param pro3rel1spr1fea1
	 *            the pro3rel1spr1fea1 to set
	 */
	protected void setPro3rel1spr1fea1(final Bug pro3rel1spr1fea1) {
		this.pro3rel1spr1fea1 = pro3rel1spr1fea1;
	}

	/**
	 * @return the pro3rel1spr1fea1
	 */
	protected Bug getPro3rel1spr1fea1() {
		return this.pro3rel1spr1fea1;
	}

	/**
	 * @param pro3rel1spr1fea2
	 *            the pro3rel1spr1fea2 to set
	 */
	protected void setPro3rel1spr1fea2(final Feature pro3rel1spr1fea2) {
		this.pro3rel1spr1fea2 = pro3rel1spr1fea2;
	}

	/**
	 * @return the pro3rel1spr1fea2
	 */
	protected Feature getPro3rel1spr1fea2() {
		return this.pro3rel1spr1fea2;
	}

	/**
	 * @param pro3rel1spr1fea3
	 *            the pro3rel1spr1fea3 to set
	 */
	protected void setPro3rel1spr1fea3(final Feature pro3rel1spr1fea3) {
		this.pro3rel1spr1fea3 = pro3rel1spr1fea3;
	}

	/**
	 * @return the pro3rel1spr1fea3
	 */
	protected Feature getPro3rel1spr1fea3() {
		return this.pro3rel1spr1fea3;
	}

	/**
	 * @param pro3rel1spr1fea4
	 *            the pro3rel1spr1fea4 to set
	 */
	protected void setPro3rel1spr1fea4(final Feature pro3rel1spr1fea4) {
		this.pro3rel1spr1fea4 = pro3rel1spr1fea4;
	}

	/**
	 * @return the pro3rel1spr1fea4
	 */
	protected Feature getPro3rel1spr1fea4() {
		return this.pro3rel1spr1fea4;
	}

	/**
	 * @param pro3rel1spr1fea5
	 *            the pro3rel1spr1fea5 to set
	 */
	protected void setPro3rel1spr1fea5(final Feature pro3rel1spr1fea5) {
		this.pro3rel1spr1fea5 = pro3rel1spr1fea5;
	}

	/**
	 * @return the pro3rel1spr1fea5
	 */
	protected Feature getPro3rel1spr1fea5() {
		return this.pro3rel1spr1fea5;
	}

	/**
	 * @param pro3rel1spr2fea1
	 *            the pro3rel1spr2fea1 to set
	 */
	protected void setPro3rel1spr2fea1(final Feature pro3rel1spr2fea1) {
		this.pro3rel1spr2fea1 = pro3rel1spr2fea1;
	}

	/**
	 * @return the pro3rel1spr2fea1
	 */
	protected Feature getPro3rel1spr2fea1() {
		return this.pro3rel1spr2fea1;
	}

	/**
	 * @param pro3rel1spr2fea2
	 *            the pro3rel1spr2fea2 to set
	 */
	protected void setPro3rel1spr2fea2(final Feature pro3rel1spr2fea2) {
		this.pro3rel1spr2fea2 = pro3rel1spr2fea2;
	}

	/**
	 * @return the pro3rel1spr2fea2
	 */
	protected Feature getPro3rel1spr2fea2() {
		return this.pro3rel1spr2fea2;
	}

	/**
	 * @param pro3rel1spr2fea3
	 *            the pro3rel1spr2fea3 to set
	 */
	protected void setPro3rel1spr2fea3(final Bug pro3rel1spr2fea3) {
		this.pro3rel1spr2fea3 = pro3rel1spr2fea3;
	}

	/**
	 * @return the pro3rel1spr2fea3
	 */
	protected Bug getPro3rel1spr2fea3() {
		return this.pro3rel1spr2fea3;
	}

	/**
	 * @param pro3rel1spr2fea4
	 *            the pro3rel1spr2fea4 to set
	 */
	protected void setPro3rel1spr2fea4(final Bug pro3rel1spr2fea4) {
		this.pro3rel1spr2fea4 = pro3rel1spr2fea4;
	}

	/**
	 * @return the pro3rel1spr2fea4
	 */
	protected Bug getPro3rel1spr2fea4() {
		return this.pro3rel1spr2fea4;
	}

	/**
	 * @param pro3rel1spr2fea5
	 *            the pro3rel1spr2fea5 to set
	 */
	protected void setPro3rel1spr2fea5(final Feature pro3rel1spr2fea5) {
		this.pro3rel1spr2fea5 = pro3rel1spr2fea5;
	}

	/**
	 * @return the pro3rel1spr2fea5
	 */
	protected Feature getPro3rel1spr2fea5() {
		return this.pro3rel1spr2fea5;
	}

	/**
	 * @param pro3rel1spr3fea1
	 *            the pro3rel1spr3fea1 to set
	 */
	protected void setPro3rel1spr3fea1(final Feature pro3rel1spr3fea1) {
		this.pro3rel1spr3fea1 = pro3rel1spr3fea1;
	}

	/**
	 * @return the pro3rel1spr3fea1
	 */
	protected Feature getPro3rel1spr3fea1() {
		return this.pro3rel1spr3fea1;
	}

	/**
	 * @param pro3rel1spr3fea2
	 *            the pro3rel1spr3fea2 to set
	 */
	protected void setPro3rel1spr3fea2(final Feature pro3rel1spr3fea2) {
		this.pro3rel1spr3fea2 = pro3rel1spr3fea2;
	}

	/**
	 * @return the pro3rel1spr3fea2
	 */
	protected Feature getPro3rel1spr3fea2() {
		return this.pro3rel1spr3fea2;
	}

	/**
	 * @param pro3rel1spr3fea3
	 *            the pro3rel1spr3fea3 to set
	 */
	protected void setPro3rel1spr3fea3(final Bug pro3rel1spr3fea3) {
		this.pro3rel1spr3fea3 = pro3rel1spr3fea3;
	}

	/**
	 * @return the pro3rel1spr3fea3
	 */
	protected Bug getPro3rel1spr3fea3() {
		return this.pro3rel1spr3fea3;
	}

	/**
	 * @param pro3rel1spr3fea4
	 *            the pro3rel1spr3fea4 to set
	 */
	protected void setPro3rel1spr3fea4(final Feature pro3rel1spr3fea4) {
		this.pro3rel1spr3fea4 = pro3rel1spr3fea4;
	}

	/**
	 * @return the pro3rel1spr3fea4
	 */
	protected Feature getPro3rel1spr3fea4() {
		return this.pro3rel1spr3fea4;
	}

	/**
	 * @param pro3rel1spr3fea5
	 *            the pro3rel1spr3fea5 to set
	 */
	protected void setPro3rel1spr3fea5(final Feature pro3rel1spr3fea5) {
		this.pro3rel1spr3fea5 = pro3rel1spr3fea5;
	}

	/**
	 * @return the pro3rel1spr3fea5
	 */
	protected Feature getPro3rel1spr3fea5() {
		return this.pro3rel1spr3fea5;
	}

	/**
	 * @param pro3rel1spr4fea1
	 *            the pro3rel1spr4fea1 to set
	 */
	protected void setPro3rel1spr4fea1(final Bug pro3rel1spr4fea1) {
		this.pro3rel1spr4fea1 = pro3rel1spr4fea1;
	}

	/**
	 * @return the pro3rel1spr4fea1
	 */
	protected Bug getPro3rel1spr4fea1() {
		return this.pro3rel1spr4fea1;
	}

	/**
	 * @param pro3rel1spr4fea2
	 *            the pro3rel1spr4fea2 to set
	 */
	protected void setPro3rel1spr4fea2(final Feature pro3rel1spr4fea2) {
		this.pro3rel1spr4fea2 = pro3rel1spr4fea2;
	}

	/**
	 * @return the pro3rel1spr4fea2
	 */
	protected Feature getPro3rel1spr4fea2() {
		return this.pro3rel1spr4fea2;
	}

	/**
	 * @param pro3rel1spr4fea3
	 *            the pro3rel1spr4fea3 to set
	 */
	protected void setPro3rel1spr4fea3(final Feature pro3rel1spr4fea3) {
		this.pro3rel1spr4fea3 = pro3rel1spr4fea3;
	}

	/**
	 * @return the pro3rel1spr4fea3
	 */
	protected Feature getPro3rel1spr4fea3() {
		return this.pro3rel1spr4fea3;
	}

	/**
	 * @param pro3rel1spr4fea4
	 *            the pro3rel1spr4fea4 to set
	 */
	protected void setPro3rel1spr4fea4(final Feature pro3rel1spr4fea4) {
		this.pro3rel1spr4fea4 = pro3rel1spr4fea4;
	}

	/**
	 * @return the pro3rel1spr4fea4
	 */
	protected Feature getPro3rel1spr4fea4() {
		return this.pro3rel1spr4fea4;
	}

	/**
	 * @param pro3rel1spr4fea5
	 *            the pro3rel1spr4fea5 to set
	 */
	protected void setPro3rel1spr4fea5(final Feature pro3rel1spr4fea5) {
		this.pro3rel1spr4fea5 = pro3rel1spr4fea5;
	}

	/**
	 * @return the pro3rel1spr4fea5
	 */
	protected Feature getPro3rel1spr4fea5() {
		return this.pro3rel1spr4fea5;
	}

	/**
	 * @param pro3rel1spr5fea1
	 *            the pro3rel1spr5fea1 to set
	 */
	protected void setPro3rel1spr5fea1(final Bug pro3rel1spr5fea1) {
		this.pro3rel1spr5fea1 = pro3rel1spr5fea1;
	}

	/**
	 * @return the pro3rel1spr5fea1
	 */
	protected Bug getPro3rel1spr5fea1() {
		return this.pro3rel1spr5fea1;
	}

	/**
	 * @param pro3rel1spr5fea2
	 *            the pro3rel1spr5fea2 to set
	 */
	protected void setPro3rel1spr5fea2(final Feature pro3rel1spr5fea2) {
		this.pro3rel1spr5fea2 = pro3rel1spr5fea2;
	}

	/**
	 * @return the pro3rel1spr5fea2
	 */
	protected Feature getPro3rel1spr5fea2() {
		return this.pro3rel1spr5fea2;
	}

	/**
	 * @param pro3rel1spr5fea3
	 *            the pro3rel1spr5fea3 to set
	 */
	protected void setPro3rel1spr5fea3(final Bug pro3rel1spr5fea3) {
		this.pro3rel1spr5fea3 = pro3rel1spr5fea3;
	}

	/**
	 * @return the pro3rel1spr5fea3
	 */
	protected Bug getPro3rel1spr5fea3() {
		return this.pro3rel1spr5fea3;
	}

	/**
	 * @param pro3rel1spr5fea4
	 *            the pro3rel1spr5fea4 to set
	 */
	protected void setPro3rel1spr5fea4(final Feature pro3rel1spr5fea4) {
		this.pro3rel1spr5fea4 = pro3rel1spr5fea4;
	}

	/**
	 * @return the pro3rel1spr5fea4
	 */
	protected Feature getPro3rel1spr5fea4() {
		return this.pro3rel1spr5fea4;
	}

	/**
	 * @param pro3rel1spr5fea5
	 *            the pro3rel1spr5fea5 to set
	 */
	protected void setPro3rel1spr5fea5(final Bug pro3rel1spr5fea5) {
		this.pro3rel1spr5fea5 = pro3rel1spr5fea5;
	}

	/**
	 * @return the pro3rel1spr5fea5
	 */
	protected Bug getPro3rel1spr5fea5() {
		return this.pro3rel1spr5fea5;
	}

	/**
	 * @param pro3rel2spr1fea1
	 *            the pro3rel2spr1fea1 to set
	 */
	protected void setPro3rel2spr1fea1(final Bug pro3rel2spr1fea1) {
		this.pro3rel2spr1fea1 = pro3rel2spr1fea1;
	}

	/**
	 * @return the pro3rel2spr1fea1
	 */
	protected Bug getPro3rel2spr1fea1() {
		return this.pro3rel2spr1fea1;
	}

	/**
	 * @param pro3rel2spr1fea2
	 *            the pro3rel2spr1fea2 to set
	 */
	protected void setPro3rel2spr1fea2(final Feature pro3rel2spr1fea2) {
		this.pro3rel2spr1fea2 = pro3rel2spr1fea2;
	}

	/**
	 * @return the pro3rel2spr1fea2
	 */
	protected Feature getPro3rel2spr1fea2() {
		return this.pro3rel2spr1fea2;
	}

	/**
	 * @param pro3rel2spr1fea3
	 *            the pro3rel2spr1fea3 to set
	 */
	protected void setPro3rel2spr1fea3(final Bug pro3rel2spr1fea3) {
		this.pro3rel2spr1fea3 = pro3rel2spr1fea3;
	}

	/**
	 * @return the pro3rel2spr1fea3
	 */
	protected Bug getPro3rel2spr1fea3() {
		return this.pro3rel2spr1fea3;
	}

	/**
	 * @param pro3rel2spr1fea4
	 *            the pro3rel2spr1fea4 to set
	 */
	protected void setPro3rel2spr1fea4(final Feature pro3rel2spr1fea4) {
		this.pro3rel2spr1fea4 = pro3rel2spr1fea4;
	}

	/**
	 * @return the pro3rel2spr1fea4
	 */
	protected Feature getPro3rel2spr1fea4() {
		return this.pro3rel2spr1fea4;
	}

	/**
	 * @param pro3rel2spr1fea5
	 *            the pro3rel2spr1fea5 to set
	 */
	protected void setPro3rel2spr1fea5(final Feature pro3rel2spr1fea5) {
		this.pro3rel2spr1fea5 = pro3rel2spr1fea5;
	}

	/**
	 * @return the pro3rel2spr1fea5
	 */
	protected Feature getPro3rel2spr1fea5() {
		return this.pro3rel2spr1fea5;
	}

	/**
	 * @param pro3rel2spr2fea1
	 *            the pro3rel2spr2fea1 to set
	 */
	protected void setPro3rel2spr2fea1(final Feature pro3rel2spr2fea1) {
		this.pro3rel2spr2fea1 = pro3rel2spr2fea1;
	}

	/**
	 * @return the pro3rel2spr2fea1
	 */
	protected Feature getPro3rel2spr2fea1() {
		return this.pro3rel2spr2fea1;
	}

	/**
	 * @param pro3rel2spr2fea2
	 *            the pro3rel2spr2fea2 to set
	 */
	protected void setPro3rel2spr2fea2(final Feature pro3rel2spr2fea2) {
		this.pro3rel2spr2fea2 = pro3rel2spr2fea2;
	}

	/**
	 * @return the pro3rel2spr2fea2
	 */
	protected Feature getPro3rel2spr2fea2() {
		return this.pro3rel2spr2fea2;
	}

	/**
	 * @param pro3rel2spr2fea3
	 *            the pro3rel2spr2fea3 to set
	 */
	protected void setPro3rel2spr2fea3(final Bug pro3rel2spr2fea3) {
		this.pro3rel2spr2fea3 = pro3rel2spr2fea3;
	}

	/**
	 * @return the pro3rel2spr2fea3
	 */
	protected Bug getPro3rel2spr2fea3() {
		return this.pro3rel2spr2fea3;
	}

	/**
	 * @param pro3rel2spr2fea4
	 *            the pro3rel2spr2fea4 to set
	 */
	protected void setPro3rel2spr2fea4(final Bug pro3rel2spr2fea4) {
		this.pro3rel2spr2fea4 = pro3rel2spr2fea4;
	}

	/**
	 * @return the pro3rel2spr2fea4
	 */
	protected Bug getPro3rel2spr2fea4() {
		return this.pro3rel2spr2fea4;
	}

	/**
	 * @param pro3rel2spr2fea5
	 *            the pro3rel2spr2fea5 to set
	 */
	protected void setPro3rel2spr2fea5(final Feature pro3rel2spr2fea5) {
		this.pro3rel2spr2fea5 = pro3rel2spr2fea5;
	}

	/**
	 * @return the pro3rel2spr2fea5
	 */
	protected Feature getPro3rel2spr2fea5() {
		return this.pro3rel2spr2fea5;
	}

	/**
	 * @param pro3rel2spr3fea1
	 *            the pro3rel2spr3fea1 to set
	 */
	protected void setPro3rel2spr3fea1(final Feature pro3rel2spr3fea1) {
		this.pro3rel2spr3fea1 = pro3rel2spr3fea1;
	}

	/**
	 * @return the pro3rel2spr3fea1
	 */
	protected Feature getPro3rel2spr3fea1() {
		return this.pro3rel2spr3fea1;
	}

	/**
	 * @param pro3rel2spr3fea2
	 *            the pro3rel2spr3fea2 to set
	 */
	protected void setPro3rel2spr3fea2(final Bug pro3rel2spr3fea2) {
		this.pro3rel2spr3fea2 = pro3rel2spr3fea2;
	}

	/**
	 * @return the pro3rel2spr3fea2
	 */
	protected Bug getPro3rel2spr3fea2() {
		return this.pro3rel2spr3fea2;
	}

	/**
	 * @param pro3rel2spr3fea3
	 *            the pro3rel2spr3fea3 to set
	 */
	protected void setPro3rel2spr3fea3(final Feature pro3rel2spr3fea3) {
		this.pro3rel2spr3fea3 = pro3rel2spr3fea3;
	}

	/**
	 * @return the pro3rel2spr3fea3
	 */
	protected Feature getPro3rel2spr3fea3() {
		return this.pro3rel2spr3fea3;
	}

	/**
	 * @param pro3rel2spr3fea4
	 *            the pro3rel2spr3fea4 to set
	 */
	protected void setPro3rel2spr3fea4(final Feature pro3rel2spr3fea4) {
		this.pro3rel2spr3fea4 = pro3rel2spr3fea4;
	}

	/**
	 * @return the pro3rel2spr3fea4
	 */
	protected Feature getPro3rel2spr3fea4() {
		return this.pro3rel2spr3fea4;
	}

	/**
	 * @param pro3rel2spr3fea5
	 *            the pro3rel2spr3fea5 to set
	 */
	protected void setPro3rel2spr3fea5(final Bug pro3rel2spr3fea5) {
		this.pro3rel2spr3fea5 = pro3rel2spr3fea5;
	}

	/**
	 * @return the pro3rel2spr3fea5
	 */
	protected Bug getPro3rel2spr3fea5() {
		return this.pro3rel2spr3fea5;
	}

	/**
	 * @param pro3rel2spr4fea1
	 *            the pro3rel2spr4fea1 to set
	 */
	protected void setPro3rel2spr4fea1(final Feature pro3rel2spr4fea1) {
		this.pro3rel2spr4fea1 = pro3rel2spr4fea1;
	}

	/**
	 * @return the pro3rel2spr4fea1
	 */
	protected Feature getPro3rel2spr4fea1() {
		return this.pro3rel2spr4fea1;
	}

	/**
	 * @param pro3rel2spr4fea2
	 *            the pro3rel2spr4fea2 to set
	 */
	protected void setPro3rel2spr4fea2(final Feature pro3rel2spr4fea2) {
		this.pro3rel2spr4fea2 = pro3rel2spr4fea2;
	}

	/**
	 * @return the pro3rel2spr4fea2
	 */
	protected Feature getPro3rel2spr4fea2() {
		return this.pro3rel2spr4fea2;
	}

	/**
	 * @param pro3rel2spr4fea3
	 *            the pro3rel2spr4fea3 to set
	 */
	protected void setPro3rel2spr4fea3(final Bug pro3rel2spr4fea3) {
		this.pro3rel2spr4fea3 = pro3rel2spr4fea3;
	}

	/**
	 * @return the pro3rel2spr4fea3
	 */
	protected Bug getPro3rel2spr4fea3() {
		return this.pro3rel2spr4fea3;
	}

	/**
	 * @param pro3rel2spr4fea4
	 *            the pro3rel2spr4fea4 to set
	 */
	protected void setPro3rel2spr4fea4(final Bug pro3rel2spr4fea4) {
		this.pro3rel2spr4fea4 = pro3rel2spr4fea4;
	}

	/**
	 * @return the pro3rel2spr4fea4
	 */
	protected Bug getPro3rel2spr4fea4() {
		return this.pro3rel2spr4fea4;
	}

	/**
	 * @param pro3rel2spr4fea5
	 *            the pro3rel2spr4fea5 to set
	 */
	protected void setPro3rel2spr4fea5(final Feature pro3rel2spr4fea5) {
		this.pro3rel2spr4fea5 = pro3rel2spr4fea5;
	}

	/**
	 * @return the pro3rel2spr4fea5
	 */
	protected Feature getPro3rel2spr4fea5() {
		return this.pro3rel2spr4fea5;
	}

	/**
	 * @param pro3rel2spr5fea1
	 *            the pro3rel2spr5fea1 to set
	 */
	protected void setPro3rel2spr5fea1(final Bug pro3rel2spr5fea1) {
		this.pro3rel2spr5fea1 = pro3rel2spr5fea1;
	}

	/**
	 * @return the pro3rel2spr5fea1
	 */
	protected Bug getPro3rel2spr5fea1() {
		return this.pro3rel2spr5fea1;
	}

	/**
	 * @param pro3rel2spr5fea2
	 *            the pro3rel2spr5fea2 to set
	 */
	protected void setPro3rel2spr5fea2(final Bug pro3rel2spr5fea2) {
		this.pro3rel2spr5fea2 = pro3rel2spr5fea2;
	}

	/**
	 * @return the pro3rel2spr5fea2
	 */
	protected Bug getPro3rel2spr5fea2() {
		return this.pro3rel2spr5fea2;
	}

	/**
	 * @param pro3rel2spr5fea3
	 *            the pro3rel2spr5fea3 to set
	 */
	protected void setPro3rel2spr5fea3(final Bug pro3rel2spr5fea3) {
		this.pro3rel2spr5fea3 = pro3rel2spr5fea3;
	}

	/**
	 * @return the pro3rel2spr5fea3
	 */
	protected Bug getPro3rel2spr5fea3() {
		return this.pro3rel2spr5fea3;
	}

	/**
	 * @param pro3rel2spr5fea4
	 *            the pro3rel2spr5fea4 to set
	 */
	protected void setPro3rel2spr5fea4(final Bug pro3rel2spr5fea4) {
		this.pro3rel2spr5fea4 = pro3rel2spr5fea4;
	}

	/**
	 * @return the pro3rel2spr5fea4
	 */
	protected Bug getPro3rel2spr5fea4() {
		return this.pro3rel2spr5fea4;
	}

	/**
	 * @param pro3rel2spr5fea5
	 *            the pro3rel2spr5fea5 to set
	 */
	protected void setPro3rel2spr5fea5(final Bug pro3rel2spr5fea5) {
		this.pro3rel2spr5fea5 = pro3rel2spr5fea5;
	}

	/**
	 * @return the pro3rel2spr5fea5
	 */
	protected Bug getPro3rel2spr5fea5() {
		return this.pro3rel2spr5fea5;
	}

	/**
	 * @param listOfFeatures
	 *            the listOfFeatures to set
	 */
	public void setListOfFeatures(final Collection<ProductBacklogItem> listOfFeatures) {
		this.listOfFeatures = listOfFeatures;
	}

	/**
	 * @return the listOfFeatures
	 */
	public Collection<ProductBacklogItem> getListOfFeatures() {
		return this.listOfFeatures;
	}

}
