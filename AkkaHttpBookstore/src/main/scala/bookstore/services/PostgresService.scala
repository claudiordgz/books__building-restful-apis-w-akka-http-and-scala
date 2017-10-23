package bookstore.services

import slick.jdbc.{JdbcProfile, PostgresProfile}
import slick.jdbc.PostgresProfile.api._


class PostgresService(jdbcUrl: String, dbUser: String, dbPassword: String) extends DatabaseService {

  // Setup our database driver, Postgres in this case
  val driver: JdbcProfile = PostgresProfile

  // Create a database connection
  val db: Database = Database.forURL(jdbcUrl, dbUser, dbPassword)
  db.createSession()
}