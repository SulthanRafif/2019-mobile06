package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.fragments.BlankFragment;
import id.ac.polinema.idealbodyweight.fragments.BodyMassIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.fragments.ResultFragment;
import id.ac.polinema.idealbodyweight.fragments.ResultFragment2;
import id.ac.polinema.idealbodyweight.util.BodyMassIndex;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener, BrocaIndexFragment.OnFragmentInteractionListener, ResultFragment.OnFragmentInteractionListener, BodyMassIndexFragment.OnFragmentInteractionListener, ResultFragment2.OnFragmentInteractionListener {

	// Deklarasikan atribut Fragment di sini
	BlankFragment blankFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private BodyMassIndexFragment bodyMassIndexFragment;
	private ResultFragment resultFragment;
	private ResultFragment2 resultFragment2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		brocaIndexFragment = new BrocaIndexFragment();
		MenuFragment menuFragment = new MenuFragment();

		resultFragment = new ResultFragment();


		bodyMassIndexFragment = new BodyMassIndexFragment();
		resultFragment2 = new ResultFragment2();


		blankFragment = BlankFragment.newInstance("Sulthan Rafif");
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if(item.getItemId() == R.id.menu_about){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, blankFragment)
					.addToBackStack(null)
					.commit();
		}


		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, brocaIndexFragment).
					commit();

	}

	@Override
	public void onBodyMassIndexButtonClicked() {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container,bodyMassIndexFragment)
					.commit();
	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}

	@Override
	public void onTryAgainButtonClicked(String tag) {
		if(tag.equals("BrocaIndex")){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, brocaIndexFragment)
					.commit();
		}

		else if(tag.equals("BodyMassIndex")){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, bodyMassIndexFragment)
					.commit();
		}
	}

	@Override
	public void onCalculateBodyMassIndexClicked(float index) {
		resultFragment2.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment2)
				.commit();
	}
}
