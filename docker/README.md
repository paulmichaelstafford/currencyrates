Postgres

	pgloader mysql://oghamstoneuser:CJ17elaBsKEMUU4l@localhost:3306/oghamstone postgresql://oghamstoneuser:password@localhost:5433/oghamstone
	pg_dump postgresql://devs:password@localhost:5433/oghamstone > oghamstone.bak
	psql postgresql://devs:password@localhost:5433/database-neptune < oghamstone.bak
	pg_isready -d oghamstone -h localhost -p 5432 -U oghamstoneuser 
