package Training;
class Employee
        {
        private String name;
        private Double salary;
        public void setEmployee(String name,Double salary)
        {
            this.name=name;
            this.salary=salary;
        }

            public String getName() {
                return name;
            }

            public Double getSalary() {
                return salary;
            }
        }
              class Manager extends Employee
              {
                  private Double bonus;

                  public void setBonus(Double bonus) {
                      this.bonus = bonus;
                  }
                  public Double getIncome()
                  {
                      Double Income;
                      Income=getSalary()+bonus;
                      return Income;
                  }
              }
              class UseManager
              {
                  public static void main (String []args) {
                      Manager boss;
                      boss=new Manager();
                      boss.setEmployee("asim",25000.0);
                      boss.setBonus(20000.0);
                      System.out.println("Managers name:"+boss.getName());
                  System.out.println("Manager Income :"+boss.getIncome());
                  }
              }
