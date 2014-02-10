# Show Tracker Web App

ember.js application served through Jetty via Spark micro framework.

**this is completely separate of the similarly named project Show Tracker Web Service

# Prerequisites

* maven
* java
* postgresql

# Setup

	-- Table: shows
	
	-- DROP TABLE shows;
	
	CREATE TABLE shows
	(
	  id integer NOT NULL DEFAULT nextval('"Shows_id_seq"'::regclass),
	  title character varying NOT NULL,
	  episode integer NOT NULL DEFAULT 1,
	  CONSTRAINT "Shows_pkey" PRIMARY KEY (id),
	  CONSTRAINT "no same titles" UNIQUE (title)
	)
	WITH (
	  OIDS=FALSE
	);
	ALTER TABLE shows
	  OWNER TO "pg-user";
	COMMENT ON TABLE shows
	  IS 'for ShowTrackerService';


# History

Feb 9: Grand release of 1.0