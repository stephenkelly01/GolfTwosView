use strict;    # safety net
use warnings;  # safety net
use feature 'say'; # a better "print"

use Mojo;

use Mojo::UserAgent;
# fetch the stackoverflow perl page

my $ua = Mojo::UserAgent->new;
my $perl_page = $ua->get('https://www.masterscoreboard.co.uk/mobile/results/HandicapList.php?CWID=4465')->res->dom;

# extract all players handicaps

#my $players = $perl_page->at('#players');
for my $players ($players->find('<td align=left>')->each) {
  print $players
  #say "  <", $players->attr(' </td>'), ">";
}