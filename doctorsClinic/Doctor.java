package doctorsClinic;

public class Doctor implements Runnable {
	int consultingTime;
	
	

	public Doctor(int consultingTime) {
		super();
		this.consultingTime = consultingTime;
	}



	@Override
	public void run() {
		Patient p;
		int currCount = 0;
		while(currCount < ClinicManager.maxPatientCount) {
			synchronized(Clinic.patientQ) {
				p = Clinic.patientQ.poll();
			}
			if(p != null) {
				System.out.println("Consulting patient "+p.id);
				try {
					Thread.sleep(consultingTime);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				p.endTime = System.currentTimeMillis();
				ClinicManager.patientWaitTime += (p.endTime - p.startTime);
				currCount++;
			}
		}
		
	}
}
