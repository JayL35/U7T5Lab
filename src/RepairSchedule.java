import java.util.ArrayList;

public class RepairSchedule
{
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n)
    {
        numberOfMechanics = n;
        schedule = new ArrayList<CarRepair>();
    }

    public ArrayList<CarRepair> getSchedule()
    {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b)
    {
        for (CarRepair cars : schedule)
        {
            if (cars.getMechanicNum() == m || cars.getBayNum() == b)
            {
                return false; // STUB VALUE
            }
        }

        CarRepair newCar = new CarRepair(m, b);
        schedule.add(newCar);
        return true;
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics()
    {
        ArrayList<Integer> avaiableNums = new ArrayList<Integer>();
        for (int i = 0; i < numberOfMechanics; i++)
        {
            avaiableNums.add(i);
            for (int j = 0; j < schedule.size(); j++)
            {
                if (schedule.get(j).getMechanicNum() == i)
                {
                    avaiableNums.remove(avaiableNums.size() - 1);
                }
            }
        }
        if (avaiableNums.size() == 0)
        {
            return null; // STUB VALUE
        }
        return avaiableNums;
    }

    /** Removes an element from schedule when a repair is complete. */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}