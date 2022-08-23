package doctorsClinic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Clinic implements Runnable {
	static Queue<Patient> patientQ = new LinkedList<>();
	
	int patientCount = 0;
	long clinicOpenTime;
	
	int maxPatientArrivalGap;

	public Clinic(int maxPatientArrivalGap) {
		super();
		this.maxPatientArrivalGap = maxPatientArrivalGap;
	}

	@Override
	public void run() {
		clinicOpenTime = System.currentTimeMillis();
		Random r = new Random();
		int randomTime;
		while(patientCount < ClinicManager.maxPatientCount) {
			Patient p = new Patient();
			p.startTime = System.currentTimeMillis();
			p.id = patientCount + 1;
			synchronized(patientQ) {
				patientQ.offer(p);
				System.out.println("Adding patient "+p.id+" to the queue");
				patientCount++;
			}
			randomTime = r.nextInt(0, maxPatientArrivalGap);
			try {
				
				Thread.sleep(randomTime);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
}
